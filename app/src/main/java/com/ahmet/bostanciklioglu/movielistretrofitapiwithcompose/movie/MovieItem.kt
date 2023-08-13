package com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.movie

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.R
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.model.Movie

@Composable
fun MovieItem(movie: Movie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Surface {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = movie.imageUrl)
                            .apply(
                                block = fun ImageRequest.Builder.() {
                                    scale(Scale.FILL)
                                    placeholder(R.drawable.placeholder)
                                    transformations(CircleCropTransformation())
                                }
                            ).build()
                    ),
                    contentDescription = movie.desc,
                    modifier = modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movie.category,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = movie.desc,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}