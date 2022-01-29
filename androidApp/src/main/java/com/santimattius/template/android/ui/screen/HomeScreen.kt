package com.santimattius.template.android.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.santimattius.template.android.R
import com.santimattius.template.android.ui.models.PictureUiModel
import com.santimattius.template.android.ui.viewmodels.HomeViewModel
import com.santimattius.template.android.ui.viewmodels.isEmpty
import org.koin.androidx.compose.getViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    onClick: (PictureUiModel) -> Unit,
) {
    val viewModel: HomeViewModel = getViewModel()
    HomeScreen(viewModel, onClick)
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: HomeViewModel, onClick: (PictureUiModel) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        when {
            viewModel.state.isLoading -> LoadingIndicator()
            viewModel.state.hasError -> ErrorView(
                message = stringResource(R.string.text_error),
                retryText = stringResource(R.string.text_retry)
            ) {
                viewModel.retry()
            }
            viewModel.state.isEmpty -> ErrorView(stringResource(R.string.text_empty))
            else -> ListOfPicture(
                pictures = viewModel.state.pictures,
                onClick = onClick
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ListOfPicture(pictures: List<PictureUiModel>, onClick: (PictureUiModel) -> Unit) {
    LazyColumn {
        items(pictures, key = { it.id }) { picture ->
            PictureCard(picture = picture, modifier = Modifier.clickable {
                onClick(picture)
            })
        }
    }
}

@ExperimentalCoilApi
@Composable
fun PictureCard(picture: PictureUiModel, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(
            vertical = dimensionResource(R.dimen.medium),
            horizontal = dimensionResource(R.dimen.large)
        )) {
        Column {
            Image(
                painter = rememberImagePainter(data = picture.imageUrl),
                contentDescription = picture.author,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .aspectRatio(ratio = (16 / 8).toFloat()),
            )
            Box(
                modifier = Modifier.padding(
                    dimensionResource(R.dimen.small),
                    dimensionResource(R.dimen.medium)
                )
            ) {
                Text(
                    text = picture.author,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 2
                )
            }
        }
    }
}