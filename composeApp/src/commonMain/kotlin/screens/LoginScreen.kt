package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PhoneLoginScreen() {
    var phoneNumber by remember { mutableStateOf("+91 ") }
    Box {
        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text("Glad to see you!")
            TextField(value = phoneNumber, onValueChange = {newValue ->
                phoneNumber = newValue
            })
            Button(onClick = {

            }){
                Text("Verify")
            }
        }
    }

}