package com.example.navegationapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitleView(name: String){
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton(name:String, backColor: Color, color: Color, onClick:() -> Unit){
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
        contentColor = color,
        containerColor = backColor
    ) ) {
        Text(text = name)
    }
}


@Composable
fun SpaceH(size: Dp =5.dp)
{
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceW(size: Dp =5.dp)
{
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun TextFields(value: String, onValueChange: (String) -> Unit, label: String)
{//Es para que se ingrese un numero
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label={ Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp))
}

@Composable
fun BotonReutilizable(text:String, color: Color = MaterialTheme.colorScheme.primary, onclick:()->Unit)
{
    OutlinedButton(
        onclick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun Alerta(
    title:String,
    mensaje:String,
    mensajeConfirma:String,
    onConfirmClick:()->Unit,
    onDismissClick:()->Unit
)
{
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = title) },
        text = { Text(text = mensaje) },
        confirmButton = {
            Button(onClick={onConfirmClick()}){
                Text(text = mensajeConfirma)
            }
        }
    )
}









