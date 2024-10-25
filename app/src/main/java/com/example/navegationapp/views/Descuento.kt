package com.example.navegationapp.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navegationapp.components.BotonReutilizable
import com.example.navegationapp.components.DosTarjetas
import com.example.navegationapp.components.MainButton
import com.example.navegationapp.components.MainIconButton
import com.example.navegationapp.components.Space
import com.example.navegationapp.components.SpaceH
import com.example.navegationapp.components.TextFields

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Descuentos(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFFFB445B)
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        // Llamada correcta a TitleBar
                        TitleBar(name = "DESCUENTOS")
                    }
                }
            )
        },
        content = { padding ->
            ContentHomeView(padding, navController)
        }
    )
}

@Composable
fun TitleBar(name: String) {
    Text(
        text = name,
        fontWeight = FontWeight.Bold, // Hacer el texto en negrita
        style = MaterialTheme.typography.titleLarge,
        color = Color.White // Color blanco para el texto
    )
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioTotal by remember { mutableStateOf("") }
        var descuentoTotal by remember { mutableStateOf("") }
        var errorMessage by remember { mutableStateOf("") }

        // Mostrar mensaje de error si hay
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }

        DosTarjetas(titulo1 = "Total", numero1 = precioTotal, titulo2 = "Descuento", numero2 = descuentoTotal)

        // Inputs
        TextFields(value = precio, onValueChange = { precio = it }, label = "Precio")
        SpaceH()
        TextFields(value = descuento, onValueChange = { descuento = it }, label = "Descuento (%)")
        SpaceH(10.dp)
        Space()

        // Botón de calcular
        BotonReutilizable(text = "Calcular") {
            errorMessage = ""
            val parsedPrecio = precio.toDoubleOrNull()
            val parsedDescuento = descuento.toDoubleOrNull()

            if (parsedPrecio != null && parsedDescuento != null) {
                val descuentoCalculado = parsedPrecio * parsedDescuento / 100
                val precioCalculado = parsedPrecio - descuentoCalculado

                // Formatear los resultados con 2 decimales
                descuentoTotal = String.format("%.2f", descuentoCalculado)
                precioTotal = String.format("%.2f", precioCalculado)
            } else {
                errorMessage = "Por favor, ingrese valores válidos."
            }
        }

        Space()
        Space()

        // Botón para volver a Home
        MainButton(
            name = "Home",
            backColor = Color(0xFFFB445B),
            color = Color.White
        ) {
            navController.popBackStack()
        }
    }
}