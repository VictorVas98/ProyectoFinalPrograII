package com.example.proyectofinalprogra.screens.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofinalprogra.R
import com.example.proyectofinalprogra.datosdelistas.Articulo
import com.example.proyectofinalprogra.datosdelistas.ArticuloAni
import com.example.proyectofinalprogra.screens.home.ActionButton
import com.example.proyectofinalprogra.screens.views.ui.theme.ProyectoFinalPrograTheme

class Animales : ComponentActivity() {
    val listados : List<ArticuloAni> = listOf(
        ArticuloAni(R.drawable.chihuahua, "CHIHUAHUA", "Cachorro de chihuahua, pelaje de color café y 2 meses de edad", 200.00),
        ArticuloAni(R.drawable.pastoraleman, "PASTOR ALEMAN", "Cachorro de pastor aleman con 2 meses de edad", 250.00),
        ArticuloAni(R.drawable.gatopersa, "GATITO PERSA", "Gatito persa, pelaje color blanco y tiene 2 meses de edad", 200.00),
        ArticuloAni(R.drawable.gatosiames, "GATITO SIAMES", "Gatito siames, pelaje de color beige y tiene 2 meses de edad", 200.00),
        ArticuloAni(R.drawable.conejobb, "CONEJO", "Cria de conejo, pelaje de color blanco y tiene 2 meses de edad", 100.00),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalPrograTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaAni(listados)
                    ActionButton()
                }
            }
        }
    }
}
@Composable
fun PantallaAni(listados: List<ArticuloAni>){
    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(listados){
                item -> ListItemRow(item)
        }
    }
}
@Composable
fun ListItemRow(item: ArticuloAni){
    val masInformacion = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(70, 0, LinearEasing)
                )
                .weight(1f)
                .fillMaxWidth()) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge
                )
                if(masInformacion.value){
                    Text(
                        text = item.details,
                    )
                    Text(
                        text = item.precio.toString()
                    )
                    Image(painter = painterResource(id = item.image),
                        contentDescription = item.details,
                        modifier = Modifier
                            .size(100.dp))
                    Space()
                    Button(onClick = {

                    }) {
                        Text(text = "Agregar al carrito")
                    }
                }
            }
            OutlinedButton(onClick = {
                masInformacion.value = !masInformacion.value
            }) {
                Text(if (masInformacion.value) "Ocultar" else "Mas...")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    val listados : List<ArticuloAni> = listOf(
        ArticuloAni(R.drawable.chihuahua, "CHIHUAHUA", "Cachorro de chihuahua, pelaje de color café y 2 meses de edad", 200.00),
        ArticuloAni(R.drawable.pastoraleman, "PASTOR ALEMAN", "Cachorro de pastor aleman con 2 meses de edad", 250.00),
        ArticuloAni(R.drawable.gatopersa, "GATITO PERSA", "Gatito persa, pelaje color blanco y tiene 2 meses de edad", 200.00),
        ArticuloAni(R.drawable.gatosiames, "GATITO SIAMES", "Gatito siames, pelaje de color beige y tiene 2 meses de edad", 200.00),
        ArticuloAni(R.drawable.conejobb, "CONEJO", "Cria de conejo, pelaje de color blanco y tiene 2 meses de edad", 100.00),
    )
    ProyectoFinalPrograTheme {
        PantallaAni(listados)
    }
}