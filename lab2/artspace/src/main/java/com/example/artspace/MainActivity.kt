package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

/** Описание одной работы в галерее. */
data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val artistRes: Int,
    val year: Int
)

val artworks = listOf(
    Artwork(R.drawable.art_squares, R.string.art_squares_title, R.string.art_squares_artist, 2021),
    Artwork(R.drawable.art_waves, R.string.art_waves_title, R.string.art_waves_artist, 2022),
    Artwork(R.drawable.art_circles, R.string.art_circles_title, R.string.art_circles_artist, 2023),
    Artwork(R.drawable.art_sunset, R.string.art_sunset_title, R.string.art_sunset_artist, 2024),
)

/** Индекс следующей/предыдущей работы с переходом по кругу. */
fun nextIndex(current: Int, size: Int) = (current + 1) % size
fun previousIndex(current: Int, size: Int) = (current - 1 + size) % size

@Composable
fun ArtSpaceApp() {
    var currentIndex by rememberSaveable { mutableIntStateOf(0) }
    val artwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ArtworkWall(artwork = artwork, modifier = Modifier.padding(top = 16.dp))
        Spacer(modifier = Modifier.height(24.dp))
        ArtworkDescriptor(artwork = artwork, position = currentIndex + 1, total = artworks.size)
        Spacer(modifier = Modifier.height(24.dp))
        DisplayController(
            onPrevious = { currentIndex = previousIndex(currentIndex, artworks.size) },
            onNext = { currentIndex = nextIndex(currentIndex, artworks.size) }
        )
    }
}

/** «Стена» с картиной: рамка с тенью. */
@Composable
fun ArtworkWall(artwork: Artwork, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shadowElevation = 12.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Image(
            painter = painterResource(artwork.imageRes),
            contentDescription = stringResource(artwork.titleRes),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(28.dp)
                .width(260.dp)
        )
    }
}

/** Подпись к работе: название, автор, год и номер в коллекции. */
@Composable
fun ArtworkDescriptor(artwork: Artwork, position: Int, total: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = MaterialTheme.shapes.small
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(artwork.titleRes),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Light
            )
            Row {
                Text(
                    text = stringResource(artwork.artistRes),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " (${artwork.year})",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = stringResource(R.string.position, position, total),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun DisplayController(onPrevious: () -> Unit, onNext: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = onPrevious, modifier = Modifier.weight(1f)) {
            Text(stringResource(R.string.previous))
        }
        Button(onClick = onNext, modifier = Modifier.weight(1f)) {
            Text(stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    AppTheme {
        ArtSpaceApp()
    }
}
