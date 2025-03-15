package com.example.preparcial1

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.preparcial1.databinding.ActivityPermisosBinding
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_CAMERA
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_FINE_LOCATION
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_GALLERY
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_ACTIVITY_RECOGNITION
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_MULTIPLE
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_BACKGROUND_LOCATION
import java.io.File
import java.io.FileOutputStream

class PermisosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermisosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermisosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        solicitarPermisosIniciales()

        binding.btnChooseGallery.setOnClickListener {
            solicitarPermiso(Manifest.permission.READ_EXTERNAL_STORAGE, PERMISSION_GALLERY)
        }

        binding.btnTakePhoto.setOnClickListener {
            solicitarPermiso(Manifest.permission.CAMERA, PERMISSION_CAMERA)
        }

        binding.btnContacts.setOnClickListener {
            val intent = Intent(this, ContactosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun solicitarPermisosIniciales() {
        val permisos = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACTIVITY_RECOGNITION
        )

        if (!permisos.all { ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }) {
            ActivityCompat.requestPermissions(this, permisos, PERMISSION_MULTIPLE)
        } else {
            actualizarImagenMapa()
        }
    }

    private fun solicitarPermiso(permiso: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permiso) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permiso), requestCode)
        } else {
            when (requestCode) {
                PERMISSION_GALLERY -> openGallery()
                PERMISSION_CAMERA -> openCamera()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PERMISSION_MULTIPLE -> actualizarImagenMapa()
            PERMISSION_GALLERY -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) openGallery() else mostrarMensajeDenegado()
            PERMISSION_CAMERA -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) openCamera() else mostrarMensajeDenegado()
        }
    }

    private fun actualizarImagenMapa() {
        val ubicacionPermitida = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        binding.mapView.setImageResource(if (ubicacionPermitida) R.drawable.mapita else R.drawable.gray_map)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(intent)
    }

    private fun mostrarMensajeDenegado() {
        Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
    }

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = result.data?.data
            imageUri?.let { binding.profileImage.setImageURI(it) }
        }
    }

    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as? Bitmap
            imageBitmap?.let { binding.profileImage.setImageBitmap(it) }
        }
    }
}

