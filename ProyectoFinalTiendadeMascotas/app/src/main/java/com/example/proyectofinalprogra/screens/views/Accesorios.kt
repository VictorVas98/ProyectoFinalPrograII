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
import com.example.proyectofinalprogra.datosdelistas.Articulo
import com.example.proyectofinalprogra.screens.home.ActionButton
import com.example.proyectofinalprogra.screens.views.ui.theme.ProyectoFinalPrograTheme

class Accesorios : ComponentActivity() {
//Aquí ocupamos las variables que se crearon dentro del package datosdelistas, para utilizarlos en la lista correspondiente.
    val listado : List<Articulo> = listOf(
        Articulo(R.drawable.collarg,"COLLAR GRANDE", "Collar para perros de raza grande.", 50.00),
        Articulo(R.drawable.collarp,"COLLAR PEQUEÑO", "Collar para cahorros o gatos", 20.00),
        Articulo(R.drawable.correas,"CORREA SIMPLE", "Correa de fibras sinteticas, con un tamaño de 1.5 m.", 25.00),
        Articulo(R.drawable.correaa,"CORREA DE ACERO", "Correa de acero inoxidable, con un tamaño de de 1.5 m.", 50.00),
        Articulo(R.drawable.repelente,"REPELENTE", "Repelente aplicable a perros y gatos, mantiene alejadas a las pulgas y garrapatas.", 25.00),
        Articulo(R.drawable.shampoo,"SHAMPOO", "Shampoo apto para perros y gatos, con repelente para pulgas y garrapatas.", 25.00),
        Articulo(R.drawable.jaula,"JAULA", "Jaula de madera y malla galvaizada.", 250.00)
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
                    Pantalla(listado)
                    ActionButton()
                }
            }
        }
    }
}

@Composable
fun Pantalla(listado: List<Articulo>){
    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(listado){
            item -> ListItemRow(item)
            //en esta se crea un ListItemRow por cada item que se agregue, en este caso serían las que se encuentran en el listado.
        }
    }
}
@Composable
fun ListItemRow(item: Articulo){
    //aquí creamos la variable que estará cambiando de estado para poder visualizar u ocultar la información adicional.
    val masInformacion = remember { mutableStateOf(false) }
    Box(
        //creamos un Box para que se mantenga ordnado
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
                    //aquí se coloco una pequeña animación, para que el despliegue de la información no sea demasiado brusca.
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
            //Aquí se agrega lo que es el botn que nos permite mostra u ocultar la información adicional.
            OutlinedButton(onClick = {
                //en el inicio la variable esta en false, lo que indica que no está mostrando nada aun, pero al momento de tener un valor distinto
                //es decir que si esta en true (esta mostrando los detalles) el texto cambia automaticamente a un Ocultar.
                masInformacion.value = !masInformacion.value
            }) {
                Text(if (masInformacion.value) "Ocultar" else "Mas...")
            }
        }
    }
}
@Composable
fun Space(){
    Spacer(modifier = Modifier.size(10.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val listado : List<Articulo> = listOf(
        Articulo(R.drawable.collarg,"COLLAR GRANDE", "Collar para perros de raza grande.", 50.00),
        Articulo(R.drawable.collarp,"COLLAR PEQUEÑO", "Collar para cachorros o gatos", 25.00),
        Articulo(R.drawable.correas,"CORREA SIMPLE", "Correa de fibras sinteticas, con un tamaño de 1.5 m.", .00),
        Articulo(R.drawable.correaa,"CORREA DE ACERO", "Correa de acero inoxidable, con un tamaño de de 1.5 m.", 25.00),
        Articulo(R.drawable.repelente,"REPELENTE", "Repelente aplicable a perros y gatos, mantiene alejadas a las pulgas y garrapatas.", 25.00),
        Articulo(R.drawable.shampoo,"SHAMPOO", "Shampoo apto para perros y gatos, con repelente para pulgas y garrapatas.", 25.00),
        Articulo(R.drawable.jaula,"JAULA", "Jaula de madera y malla galvaizada.", 25.00)
    )
    ProyectoFinalPrograTheme {
        Pantalla(listado)
    }
}