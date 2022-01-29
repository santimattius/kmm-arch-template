package com.santimattius.template.android.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.santimattius.template.android.R


@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .testTag("LoadingIndicator")
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(
    message: String,
    retryText: String = "",
    retryAction: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .testTag("ErrorView")
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(message, style = MaterialTheme.typography.h5)
            if (retryText.isNotEmpty()) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.medium)))
                Button(onClick = retryAction) {
                    Text(retryText, style = MaterialTheme.typography.h5)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErrorViewPreview() {
    ErrorView(
        message = stringResource(R.string.text_error),
        retryText = "Reintentar"
    )
}