package com.jerimkaura.litu.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.jerimkaura.litu.R
import com.jerimkaura.litu.data.local.Category
import com.jerimkaura.litu.data.local.Product
import com.jerimkaura.litu.ui.Route
import com.jerimkaura.litu.ui.composables.CardImageBackground
import com.jerimkaura.litu.ui.composables.SearchBar
import com.jerimkaura.litu.ui.screens.home.components.*
import com.jerimkaura.litu.ui.theme.LituTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    LituTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                DrawerHeader()
                DrawerBody(onItemClick = { navController.navigate(it.route) })
            },
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .padding(horizontal = 0.dp, vertical = 0.dp)
                        .clip(
                            shape = RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)
                        ),
                    title = { Text(text = "Litudian") },
                    elevation = 0.dp,
                    backgroundColor = if (isSystemInDarkTheme()) {
                        Color(0xff202121)
                    } else {
                        Color(0xffFF9202)
                    },
                    contentColor = Color.White,
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_menu),
                                contentDescription = "Menu Icon"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_favourite),
                                contentDescription = "Menu Icon"
                            )
                        }
                        IconButton(onClick = { navController.navigate(Route.RegisterScreen.route) }) {
                            BadgedBox(
                                badge = {
                                    Badge(
                                        backgroundColor = if (isSystemInDarkTheme()) Color(
                                            0xffFF9202
                                        ) else Color.White
                                    ) {
                                        Text(
                                            text = "3",
                                            color = if (isSystemInDarkTheme()) Color.White else Color(
                                                0xffFF9202
                                            )
                                        )
                                    }
                                }) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_shopping_cart),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                )
            },
            content = { padding ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 60.dp),
                    color = MaterialTheme.colors.background
                ) {

                    val state = rememberPagerState()
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        GreetingSection()
                        SearchBar()
                        SliderView(state, homeViewModel)
                        Spacer(modifier = Modifier.padding(4.dp))
                        DotsIndicator(
                            totalDots = homeViewModel.promotionList.size,
                            selectedIndex = state.currentPage
                        )
                        SectionHeader(
                            "Popular Categories",
                            "Explore our products by Category"
                        )
                        CategoryItems()
                        SectionHeader(
                            "Random Picks For You",
                            "Try out a few Picks we made for you"
                        )
                        ProductsItems(navController)
                        CardImageBackground(
                            header = "Make a Request",
                            description = "Request for an Item. W e deliver it to you",
                            buttonText = "Request an Item",
                            imageId = R.drawable.clothes
                        )


                    }
                    LaunchedEffect(key1 = state.currentPage) {
                        delay(5000)
                        var newPosition = state.currentPage + 1
                        if (newPosition > homeViewModel.promotionList.size - 1) newPosition = 0
                        state.scrollToPage(newPosition)
                    }
                }
            }
        )
    }

}

@Composable
fun CategoryItems() {
    val categories = remember { categories }
    LazyRow {
        items(items = categories, itemContent = { category ->
            CategoryCard(category)
        })
    }
}

@Composable
fun ProductsItems(navController: NavController) {
    val products = remember { products }
    LazyRow {
        items(items = products, itemContent = { product ->
            ProductCard(product, navController)
        })
    }
}

@Composable
fun GreetingSection() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(vertical = 30.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hello",
                modifier = Modifier.padding(start = 5.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
            Text(
                text = "Jerim,",
                modifier = Modifier.padding(start = 5.dp),
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xffFF9202),
                fontSize = 20.sp
            )
        }

        Text(
            text = "Welcome to Litudian",
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Light,
        )

    }

}

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
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl.value)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.placeholder)
                            scale(coil.size.Scale.FILL)
                        }).build()
                )
                Image(
                    painter = painter, contentDescription = "", Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xff000000).copy(alpha = 0.70F))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = homeViewModel.promotionList[page].name,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )

                    Text(
                        text = homeViewModel.promotionList[page].description,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(text = "Learn More", color = Color.White)
                    }
                }
            }
        }
    }
}


@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .height(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xffFF9202))
                )
            } else {
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .height(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xffffc980))
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}


val products = listOf(
    Product(
        "Mens",
        "https://cdn.pixabay.com/photo/2022/09/23/16/11/stones-7474749_1280.jpg",
        "KSH 1,200",
        56
    ),
    Product(
        "Mens",
        "https://cdn.pixabay.com/photo/2018/12/09/12/29/customer-3864809__480.jpg",
        "KSH 1,200",
        78
    ),
    Product(
        "Mens",
        "https://cdn.pixabay.com/photo/2022/09/23/16/11/stones-7474749_1280.jpg",
        "KSH 1,200",
        24
    ),
    Product(
        "Mens",
        "https://cdn.pixabay.com/photo/2022/09/23/16/11/stones-7474749_1280.jpg",
        "KSH 1,200",
        97
    ),
    Product(
        "Mens Boots",
        "https://cdn.pixabay.com/photo/2016/11/19/20/55/apples-1841132__480.jpg",
        "KSH 4,200",
        43
    ),
    Product(
        "Mens",
        "https://cdn.pixabay.com/photo/2022/09/23/16/11/stones-7474749_1280.jpg",
        "KSH 1,200",
        87
    )
)


private val categories = listOf(
    Category(R.drawable.mens_shoes, "Bags & Footwear"),
    Category(R.drawable.office, "Office"),
    Category(R.drawable.machines, "Machines & Industrials"),
    Category(R.drawable.outdoor, "Sports & Outdoor"),
    Category(R.drawable.k, "Home & Kitchen"),
    Category(R.drawable.business_coat, "Clothing & Apparels"),
    Category(R.drawable.electronics, "Electronics"),
    Category(R.drawable.kids, "Baby & Kids"),
    Category(R.drawable.beauty, "Beauty & Health"),
)