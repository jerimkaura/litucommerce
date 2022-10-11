package com.jerimkaura.litu.ui.screens.product

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.jerimkaura.litu.R
import com.jerimkaura.litu.data.local.ProductColor
import com.jerimkaura.litu.ui.composables.IconCircleBackground
import com.jerimkaura.litu.ui.screens.home.DotsIndicator
import com.jerimkaura.litu.ui.screens.home.HomeViewModel
import com.jerimkaura.litu.ui.theme.LituTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    LituTheme {
        Scaffold(
            topBar = { ProductTopBar(navController) },
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .padding(paddingValues),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        val state = rememberPagerState()
                        ProductImagesSlider(state = state, homeViewModel = homeViewModel)
                        DotsIndicator(
                            totalDots = homeViewModel.promotionList.size,
                            selectedIndex = state.currentPage
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        ProductParticulars()
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                        ProductHeaderSection("Product Description")
                        Text(
                            text = "Cash Deposits,EFT or RTGS transfer to UON MODULE I Collection Account No. 2032770838 at ABSA Bank, Plaza Branch",
                            modifier = Modifier
                                //.weight(8.0f)
                                .padding(top = 20.dp),
                            fontWeight = FontWeight.Bold,
                            lineHeight = 20.sp,
                            fontSize = 12.sp,
                            color = if (isSystemInDarkTheme()) Color(0xB3EFEEEF) else Color(
                                0x99121212
                            )
                        )
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                        SizeColorQuantity()
                    }
                }
            }
        )
    }
}


@Composable
@Preview(showBackground = true)
fun SizeColorQuantity() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SizeDropDown()
            SizeDropDown()
        }
        LazyColumnWithSelection()

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SizeDropDown() {
    val width = ((LocalConfiguration.current.screenWidthDp - 50) / 2)
    Column {
        val options = listOf("36", "37", "38", "39", "40")

        var expanded by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf(options[0]) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier
                .width(width = width.dp)
                .height(60.dp)
        ) {
            TextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("Food") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }

}


@Composable
fun LazyColumnWithSelection() {
    val colors = listOf(
        ProductColor("Red", Color.Red),
        ProductColor("Blue", Color.Blue),
        ProductColor("Green", Color.Green),
        ProductColor("Pink", Color.Magenta),
        ProductColor("Yellow", Color.Yellow),
    )
    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index }
    LazyRow(
        modifier = Modifier.width(200.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        items(3) { index ->
            ColorItem(
                index = index,
                selected = selectedIndex == index,
                colors = colors,
                onClick = onItemClick
            )
        }
    }
}

@Composable
fun ColorItem(index: Int, selected: Boolean, colors: List<ProductColor>, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .clip(RoundedCornerShape(10.dp))
            .height(30.dp)
            .width(50.dp),
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    onClick.invoke(index)
                }
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, colors[index].color, shape = RoundedCornerShape(10.dp))
                .background(if (selected) colors[index].color else Color.Transparent)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = colors[index].name,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp, color = if (selected) Color.White else colors[index].color
            )
        }
    }

}

@Composable
fun ProductHeaderSection(title: String) {
    Row(
        modifier = Modifier
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = Color(0xffFF9202),
            thickness = 2.dp,
            modifier = Modifier
                .width(20.dp)
                .padding(horizontal = 10.dp)
                .weight(1.0f), startIndent = 0.dp
        )
        Text(
            text = title,
            modifier = Modifier
                .weight(8.0f),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ProductParticulars() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Color(0xffFF9202),
                thickness = 2.dp,
                modifier = Modifier
                    .width(20.dp)
                    .padding(horizontal = 10.dp)
                    .weight(1.0f), startIndent = 0.dp
            )
            Text(
                text = "Supplier MOQ: 150 Items",
                modifier = Modifier
                    .weight(8.0f),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (isSystemInDarkTheme()) Color(0xB3EFEEEF) else Color(
                    0x99121212
                )
            )
            IconCircleBackground(
                iconId = R.drawable.ic_plus,
                size = 30.dp,
                onClick = {
                }
            )
            IconCircleBackground(
                iconId = R.drawable.ic_favourite,
                size = 30.dp,
                onClick = {
                }
            )
        }
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "Men's Casual Fashion Shoes",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        Text(
            text = "KES 1,200", fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }

}

@Composable
fun ProductImageCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            val painter = painterResource(id = R.drawable.mens_shoes)
            Image(
                painter = painter, contentDescription = "", Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxSize(), contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color(0xff000000).copy(alpha = 0.10F)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductImagesSlider(state: PagerState, homeViewModel: HomeViewModel) {
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
                        .clip(RoundedCornerShape(15.dp))
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )
            }
        }
    }
}