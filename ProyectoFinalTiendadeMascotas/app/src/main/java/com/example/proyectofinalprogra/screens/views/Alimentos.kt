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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofinalprogra.R
import com.example.proyectofinalprogra.datosdelistas.ArticuloAni
import com.example.proyectofinalprogra.datosdelistas.ArticuloCom
import com.example.proyectofinalprogra.screens.home.ActionButton
import com.example.proyectofinalprogra.screens.views.ui.theme.ProyectoFinalPrograTheme

class Alimentos : ComponentActivity() {
    val listadocomida : List<ArticuloCom> = listOf(
        ArticuloCom(R.drawable.comidacachorro, "COMIDA PARA CACHORRO", "Alimento para cachorro, marca Rufo.", 24.00),
        ArticuloCom(R.drawable.comidaperro, "COMIDA PARA PERRO", "Alimento para perros adultos, marca Purina", 60.00),
        ArticuloCom(R.drawable.comidagatito, "COMIDA PARA GATITO", "Comida para gatitos, marca Miringo", 30.00),
        ArticuloCom(R.drawable.comidagato, "COMIDA PARA GATO", "Comida para gatos, marca Miringo", 70.00),
        ArticuloCom(R.drawable.comidaconejo, "COMIDA PARA CONEJO", "Comida para conejos, marca Kaytee", 30.00),
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
                    PantallaCom(listadocomida)
                    ActionButton()
                }
            }
        }
    }
}
@Composable
fun PantallaCom(listadocomida: List<ArticuloCom>){
    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(listadocomida){
                item -> ListItemRow(item)
        }
    }
}
@Composable
fun ListItemRow(item: ArticuloCom){
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
fun GreetingPreview2() {
    val listadocomida : List<ArticuloCom> = listOf(
        ArticuloCom(R.drawable.comidacachorro, "COMIDA PARA CACHORRO", "Alimento para cachorro, marca Rufo.", 24.00),
        ArticuloCom(R.drawable.comidaperro, "COMIDA PARA PERRO", "Alimento para perros adultos, marca Purina", 60.00),
        ArticuloCom(R.drawable.comidagatito, "COMIDA PARA GATITO", "Comida para gatitos, marca Miringo", 30.00),
        ArticuloCom(R.drawable.comidagato, "COMIDA PARA GATO", "Comida para gatos, marca Miringo", 70.00),
        ArticuloCom(R.drawable.comidaconejo, "COMIDA PARA CONEJO", "Comida para conejos, marca Kaytee", 30.00),
    )
    ProyectoFinalPrograTheme {
        PantallaCom(listadocomida)
    }
}