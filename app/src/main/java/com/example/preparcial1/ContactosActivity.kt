package com.example.preparcial1

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.preparcial1.databinding.ActivityContactosBinding
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_READ_CONTACTS

class ContactosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactosBinding
    private var mProjection: Array<String>? = null
    private var mCursor: Cursor? = null
    private var mContactsAdapter: ContactsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mProjection = arrayOf(ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)
        mContactsAdapter = ContactsAdapter(this, null, 0)
        binding.contactListView.adapter = mContactsAdapter

        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED -> {
                cargarContactos()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS) -> {
                pedirPermiso(this, Manifest.permission.READ_CONTACTS, "", PERMISSION_READ_CONTACTS)
            }
            else -> {
                pedirPermiso(this, Manifest.permission.READ_CONTACTS, "", PERMISSION_READ_CONTACTS)
            }
        }
    }

    private fun pedirPermiso(context: Activity, permiso: String, justificacion: String, idCode: Int) {
        if (ContextCompat.checkSelfPermission(context, permiso) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, arrayOf(permiso), idCode)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_READ_CONTACTS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    cargarContactos()
                    Toast.makeText(this, "Permiso de contactos concedido", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Permiso de contactos denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun cargarContactos() {
        mCursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI, mProjection, null, null, null
        )
        mContactsAdapter?.changeCursor(mCursor)
    }
}
