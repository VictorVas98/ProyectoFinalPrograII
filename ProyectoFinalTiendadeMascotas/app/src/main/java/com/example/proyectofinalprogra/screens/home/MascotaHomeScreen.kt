package com.example.proyectofinalprogra.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalprogra.R
import com.example.proyectofinalprogra.screens.carrito.Carrito
import com.example.proyectofinalprogra.screens.views.Accesorios
import com.example.proyectofinalprogra.screens.views.Alimentos
import com.example.proyectofinalprogra.screens.views.Animales

@Composable
fun Home(navController: NavController){
 Elementos()
}

//En la función elementos estoy creando los espacios en los que estará la imagen del logo
//también se encuentran los espacios en los que están los botones que inician cada Activity creada, siendo el caso de:
//Mascotas hacia Animales
//Alimentos hacia Alimentos
//Accesorios hacia Accesorios
@Composable
fun Elementos() {
    //con la variable mContext me permite agregar el contexto al que me quiero desplazar.
    val mContext = LocalContext.current
    Column(
        modifier = Modifier.
        fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LOGO",
            modifier = Modifier
                .size(380.dp)
                .padding(16.dp)
        )
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(16.dp)
        ) {
            Text(
                text = "BIENVENIDO",
                color = Color.White
            )
        }
        Column(
            modifier = Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    //aquí al indicar el contexto y la activity que quiero iniciar, me traslada hacia la que se indica en el boton.
                    mContext.startActivity(Intent(mContext, Animales::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("MASCOTAS")
            }
            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, Accesorios::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ACCESORIOS")
            }
            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, Alimentos::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ALIMENTOS")
            }
        }
    }
}

//Aquí cree la funcion ActionButton que me dirige hacia la activity de Carrito, para unicamente ejecutarla en las ventanas de Animales, Accesorios y Alimentos.
@Composable
fun ActionButton() {
    val mContext = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                mContext.startActivity(Intent(mContext, Carrito::class.java))
            },
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Agregar"
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    Elementos()
}