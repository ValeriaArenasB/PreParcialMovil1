# PreParcialMovil1


# 1. Estructura binding:

```kotlin
import com.example.preparcial1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPermisos.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
        }
```
---
---

# 🚀 **Estructura Generalizada para Agregar Permisos en Kotlin (Android Studio)**

```kotlin
// 1. Importa tu código de permisos desde Miscellaneous
import com.example.preparcial1.Miscellaneous.Companion.PERMISSION_NUEVO

// 2. Solicita el permiso desde un botón o en el flujo inicial
private fun solicitarPermisoNuevo() {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.NOMBRE_DEL_PERMISO) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.NOMBRE_DEL_PERMISO), PERMISSION_NUEVO)
    } else {
        accionSiPermisoConcedido()
    }
}

// 3. Manejo del resultado del permiso
override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    when (requestCode) {
        PERMISSION_NUEVO -> {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                accionSiPermisoConcedido()
            } else {
                mostrarMensajeDenegado()
            }
        }
    }
}

// 4. Definir la acción a realizar si el permiso es concedido
private fun accionSiPermisoConcedido() {
    // Código a ejecutar si el permiso es concedido
    Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show()
}

// 5. Mensaje si el permiso es denegado
private fun mostrarMensajeDenegado() {
    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
}
```

---

### ⚙️ **Pasos para Integrar un Nuevo Permiso**

1. **Definir el permiso en `Miscellaneous`:**

```kotlin
companion object {
    const val PERMISSION_NUEVO = 106 // Define un nuevo código único
}
```

2. **Agregar el permiso en `AndroidManifest.xml`:**

```xml
<uses-permission android:name="android.permission.NOMBRE_DEL_PERMISO" />
```

3. **Llamar a la función en tu actividad:**

- Si es un permiso inicial (cuando se abre la actividad):

```kotlin
solicitarPermisoNuevo()
```

- Si es un permiso que depende de una acción (por ejemplo, un botón):

```kotlin
binding.btnNuevoPermiso.setOnClickListener {
    solicitarPermisoNuevo()
}
```

---


✅ **¡Y listo!** Solo reemplaza:

- `NOMBRE_DEL_PERMISO` → Por el nombre del permiso de Android (ej. `Manifest.permission.READ_SMS`).
- `PERMISSION_NUEVO` → Por el código definido en `Miscellaneous`.
- Personaliza la lógica en `accionSiPermisoConcedido()` según lo que necesites que haga la app cuando se conceda el permiso.



---
---

# 📦 ESTRUCTURA GENERAL DE BINDING, INTENTS Y BUNDLES


1️⃣ INICIALIZACIÓN DE BINDING EN UNA ACTIVIDAD
```kotlin
class NombreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNombreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNombreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Uso de binding con botón
        binding.miBoton.setOnClickListener {
            mostrarMensaje("¡Botón presionado!")
        }
    }

    private fun mostrarMensaje(texto: String) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }
}
```
2️⃣ CREAR UN INTENT PARA ENVIAR DATOS A OTRA ACTIVIDAD
```kotlin
private fun enviarDatos() {
    val nombre = binding.nombreEditText.text.toString()
    val edad = binding.edadEditText.text.toString().toIntOrNull()
    val ciudad = binding.ciudadEditText.text.toString()

    if (nombre.isBlank() || edad == null || ciudad.isBlank()) {
        mostrarMensaje("Por favor, completa todos los campos")
        return
    }

    val bundle = Bundle().apply {
        putString("NOMBRE", nombre)
        putInt("EDAD", edad)
        putString("CIUDAD", ciudad)
    }

    val intent = Intent(this, OtraActivity::class.java).apply {
        putExtra("PAQUETE_DATOS", bundle)
    }

    startActivity(intent)
}
```

3️⃣ RECIBIR DATOS EN LA ACTIVIDAD DESTINO
```kotlin
class OtraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("PAQUETE_DATOS")
        val nombre = bundle?.getString("NOMBRE")
        val edad = bundle?.getInt("EDAD")
        val ciudad = bundle?.getString("CIUDAD")

        binding.textView.text = "Nombre: $nombre, Edad: $edad, Ciudad: $ciudad"
    }
}
```

4️⃣ ENVIAR UNO DE LOS DATOS EXTRAÍDOS A OTRA ACTIVIDAD
```kotlin
private fun enviarDatoEspecifico(nombre: String) {
    val intent = Intent(this, NuevaActivity::class.java)
    intent.putExtra("NOMBRE_ESPECIFICO", nombre)
    startActivity(intent)
}
```

5️⃣ RECIBIR EL DATO EN LA NUEVA ACTIVIDAD
```kotlin
class NuevaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuevaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNuevaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreRecibido = intent.getStringExtra("NOMBRE_ESPECIFICO")
        binding.textView.text = "Dato recibido: $nombreRecibido"
    }
}

```

# PASOS PARA USAR BINDING, INTENTS Y BUNDLES


1️⃣ CONFIGURAR BINDING EN build.gradle (si no está hecho)
```kotlin
android {
     buildFeatures {
         viewBinding true
     }
 }
```
 2️⃣ CREAR EL INTENT Y ENVIAR DATOS CON BUNDLE
 - Usar "putExtra" para enviar datos simples
 - Usar "Bundle" para agrupar varios datos y enviarlos juntos

 3️⃣ RECIBIR LOS DATOS
 - Usar "intent.getBundleExtra" para recibir un bundle
 - Usar "intent.getStringExtra" para recibir datos simples

 4️⃣ USO DE LOS DATOS RECIBIDOS
 - Extraer los datos del bundle y utilizarlos como se necesite

 ⚠️ NOTAS IMPORTANTES
- Verificar si los datos recibidos son nulos antes de utilizarlos.
- Utilizar mensajes Toast para notificar al usuario en caso de errores.
- Siempre validar los datos ingresados por el usuario antes de procesarlos.

---
---

# ESTRUCTURA GENERAL PARA SPINNER Y LISTVIEW CON JSON


```kotlin
package com.example.preparcial1

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityGeneralBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class GeneralActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityGeneralBinding
    private var selectedItem: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar datos en Spinner desde JSON
        cargarDatosEnSpinner(R.raw.datos_spinner, binding.spinner)

        // Cargar datos en ListView desde JSON
        cargarDatosEnListView(R.raw.datos_listview, binding.listView)

        binding.spinner.onItemSelectedListener = this
    }

    private fun cargarDatosEnSpinner(resId: Int, spinner: Spinner) {
        try {
            val jsonString = Miscellaneous.loadJSONFromRaw(this, resId)
            val jsonArray = JSONArray(jsonString)
            val listaItems = mutableListOf<String>()

            for (i in 0 until jsonArray.length()) {
                listaItems.add(jsonArray.getString(i))
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaItems)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

        } catch (e: IOException) {
            Toast.makeText(this, "Error al cargar el archivo JSON", Toast.LENGTH_SHORT).show()
        } catch (e: JSONException) {
            Toast.makeText(this, "Error en el formato del JSON", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarDatosEnListView(resId: Int, listView: ListView) {
        try {
            val jsonString = Miscellaneous.loadJSONFromRaw(this, resId)
            val jsonArray = JSONArray(jsonString)
            val listaItems = mutableListOf<String>()

            for (i in 0 until jsonArray.length()) {
                listaItems.add(jsonArray.getString(i))
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaItems)
            listView.adapter = adapter

        } catch (e: IOException) {
            Toast.makeText(this, "Error al cargar el archivo JSON", Toast.LENGTH_SHORT).show()
        } catch (e: JSONException) {
            Toast.makeText(this, "Error en el formato del JSON", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        selectedItem = parent.getItemAtPosition(position).toString()
        Toast.makeText(this, "Seleccionaste: $selectedItem", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // No hacer nada
    }
}

// ----------------------
// JSON DE EJEMPLO (datos_spinner.json y datos_listview.json en res/raw)
// ----------------------
// [
//     "Opción 1",
//     "Opción 2",
//     "Opción 3",
//     "Opción 4"
// ]

// ----------------------
// Miscellaneous.kt (Método de carga desde RAW)
// ----------------------
fun loadJSONFromRaw(context: Context, resId: Int): String? {
    return try {
        val inputStream = context.resources.openRawResource(resId)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, charset("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        null
    }
}

// ----------------------
// XML DE LA ACTIVIDAD (activity_general.xml)
// ----------------------
// <LinearLayout
//     xmlns:android="http://schemas.android.com/apk/res/android"
//     android:layout_width="match_parent"
//     android:layout_height="match_parent"
//     android:orientation="vertical"
//     android:padding="16dp">

//     <Spinner
//         android:id="@+id/spinner"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content" />

//     <ListView
//         android:id="@+id/listView"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content" />

// </LinearLayout>
```

1. Crear un **`Spinner`** y un **`ListView`** en la misma pantalla.
2. Cargar datos desde archivos JSON ubicados en la carpeta `res/raw`.
3. Gestionar la selección en el `Spinner`.

---

### ✅ **¿Cómo utilizar esta estructura?**
- Solo necesitas reemplazar los archivos JSON (`datos_spinner.json` y `datos_listview.json`) con los datos específicos que desees.
- Ajusta el nombre del recurso en las llamadas a `cargarDatosEnSpinner` o `cargarDatosEnListView` según corresponda.
- Si deseas personalizar la presentación, modifica los `ArrayAdapter` y los layouts en el XML.
- **Ubica los JSON en `res/raw`** con la estructura adecuada.



