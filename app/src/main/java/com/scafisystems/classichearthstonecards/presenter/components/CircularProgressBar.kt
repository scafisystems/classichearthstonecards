package com.scafisystems.classichearthstonecards.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scafisystems.classichearthstonecards.presenter.ui.theme.Purple200

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .size(100.dp),
            color = Purple200,
            strokeWidth = 10.dp
        )
    }

}

@Preview(name = "CircularProgressBar")
@Composable
private fun PreviewCircularProgressBar() {
    CircularProgressBar()
}