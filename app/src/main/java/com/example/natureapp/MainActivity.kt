package com.example.natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.natureapp.ui.theme.NatureAppTheme
import coil.compose.rememberAsyncImagePainter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureAppTheme {
                NatureListScreen()
            }
        }
    }
}

data class NaturalPlace(val name: String, val description: String, val imageUrl: String)

@Composable
fun NatureListScreen() {
    val places = listOf(
        NaturalPlace(
            "Chichén Itzá (Yucatán)",
            "Uno de los sitios arqueológicos más famosos del mundo, Chichén Itzá fue una gran ciudad maya. La icónica Pirámide de Kukulkán es una de las Nuevas Siete Maravillas del Mundo, destacando por su impresionante simetría y alineación con los eventos astronómicos. El sitio también alberga templos, cenotes sagrados y el Juego de Pelota.",
            "https://media.viajando.travel/p/0badf6b4b0b571dd14ac01df35da7f88/adjuntos/236/imagenes/000/498/0000498772/1200x675/smart/chichen-itza-castillokukulkan-equinoccio03-1png.png"
        ),
        NaturalPlace(
            "Cenotes de la Riviera Maya (Quintana Roo)",
            "Los cenotes son formaciones naturales que ofrecen espectaculares pozas de agua cristalina en medio de la selva. En la Riviera Maya se pueden encontrar decenas de estos cenotes, perfectos para nadar, hacer snorkel o bucear. Entre los más populares están Cenote Dos Ojos y Gran Cenote.",
            "https://www.cronista.com/files/image/415/415259/61af8f8de8c18.jpg"
        ),
        NaturalPlace(
            "Barranca del Cobre (Chihuahua)",
            "Este sistema de cañones es más grande y profundo que el Gran Cañón de Arizona, ofreciendo paisajes deslumbrantes. La Barranca del Cobre se puede explorar a través del famoso tren \"El Chepe\", que recorre las montañas y atraviesa puentes colgantes, ofreciendo vistas espectaculares.",
            "https://viajesbarrancasdelcobre.com/images/p2/prin_barrancas_del_cobre_chepe_express.jpg"
        ),
        NaturalPlace(
            "Teotihuacán (Estado de México)",
            "La antigua ciudad de Teotihuacán es un centro ceremonial prehispánico lleno de pirámides monumentales como la Pirámide del Sol y la Pirámide de la Luna. Fue una de las mayores ciudades del mundo antiguo y su origen sigue siendo un misterio. Es ideal para explorar sus templos, plazas y murales.",
            "https://www.mexicodesconocido.com.mx/wp-content/uploads/2019/04/Teotihuacan_Pano_5de-sep_color_IG.jpg"
        ),
        NaturalPlace(
            "Islas Marietas (Nayarit)",
            "Estas islas protegidas son un paraíso natural, famosas por su Playa Escondida, también conocida como Playa del Amor. Las islas son hogar de una gran biodiversidad marina, lo que las convierte en un excelente lugar para bucear o hacer snorkel. Solo se puede llegar en barco desde Puerto Vallarta o Punta de Mita.",
            "https://islasmarietas.com/wp-content/uploads/2020/10/image-asset-e1627341803332.jpeg"
        ),
        NaturalPlace(
            "Islas Marietas (Nayarit)",
            "Estas islas protegidas son un paraíso natural, famosas por su Playa Escondida, también conocida como Playa del Amor. Las islas son hogar de una gran biodiversidad marina, lo que las convierte en un excelente lugar para bucear o hacer snorkel. Solo se puede llegar en barco desde Puerto Vallarta o Punta de Mita.",
            "https://islasmarietas.com/wp-content/uploads/2020/10/image-asset-e1627341803332.jpeg"
        ),
        NaturalPlace(
            "Palenque (Chiapas)",
            "Es uno de los sitios arqueológicos mayas más importantes de México. Enclavado en la selva, Palenque destaca por la belleza de sus templos y su refinada arquitectura, especialmente el Templo de las Inscripciones. Es un lugar lleno de historia y rodeado de exuberante naturaleza.",
            "https://i0.wp.com/blog.vivaaerobus.com/wp-content/uploads/2022/08/palenque-chiapas.jpg?resize=1280%2C640&ssl=1"
    ),
        NaturalPlace(
            " Huasteca Potosina (San Luis Potosí)",
            "Es una región repleta de cascadas, ríos, cuevas y paisajes exuberantes. Las Cascadas de Tamul, la Cueva de las Golondrinas y el Sótano de las Huahuas son algunos de los sitios más impresionantes. Es un destino ideal para practicar ecoturismo, como rafting, senderismo y exploración de grutas.",
            "https://www.mexicodesconocido.com.mx/wp-content/uploads/2020/07/Cascada_de_Tamul_vista_desdes_abajo.jpg"
        ),
    )

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(places) { place ->
            NaturePlaceCard(place = place)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun NaturePlaceCard(place: NaturalPlace) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(model = place.imageUrl),
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = place.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = place.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NatureListScreenPreview() {
    NatureAppTheme {
        NatureListScreen()
    }
}
