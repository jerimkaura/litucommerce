package com.jerimkaura.litu.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.screens.home.HomeViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView(state: PagerState, homeViewModel: HomeViewModel) {
    val imageUrl = remember { mutableStateOf("") }
    HorizontalPager(
        state = state,
        count = homeViewModel.promotionList.size,
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) { page ->
        imageUrl.value = homeViewModel.promotionList[page].imageUrl
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {
                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl.value)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.placeholder)
                            scale(Scale.FILL)
                        }).build()
                )
                Image(
                    painter = painter, contentDescription = "", Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )

                Text(
                    text = homeViewModel.promotionList[page].name,
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp))
                        .background(Color(0xffFF9202).copy(alpha = 0.80F))
                        .padding(8.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}