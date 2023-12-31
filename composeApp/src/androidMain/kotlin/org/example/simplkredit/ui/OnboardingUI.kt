package org.example.simplkredit.ui

import android.text.Layout.Alignment
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import org.example.simplkredit.R
import org.example.simplkredit.constants.Route
import org.example.simplkredit.constants.VerificationStatus
import org.example.simplkredit.viewmodels.OnboardingViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PhoneRegistrationScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel
) {
    var phoneNumber by remember { mutableStateOf("+91 ") }
//    val phoneVerificationStatus = onboardingViewModel.phoneVerificationStatus.observeAsState()

//    if (phoneVerificationStatus.value == VerificationStatus.OtpSent) {
//        LaunchedEffect(Unit) {
//            navController.navigate(
//                "${Route.PHONE_VERIFICATION}/$phoneNumber"
//            )
//        }
//    }

    PhoneRegistrationScreen(
        phoneNumber = phoneNumber,
        onPhoneNumberChange = { newValue -> phoneNumber = newValue },
        onSendOtpClick = {
            onboardingViewModel.sendOtp(phoneNumber)
            navController.navigate(
                "${Route.PHONE_VERIFICATION}/$phoneNumber"
            )
        }
    )
}

@Composable
private fun PhoneRegistrationScreen(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    onSendOtpClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.ic_phone_registration),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
                .align(androidx.compose.ui.Alignment.CenterHorizontally)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Enter your Phone Number",
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )
                TextField(
                    value = phoneNumber,
                    onValueChange = { newValue -> onPhoneNumberChange(newValue) },
                    modifier = Modifier.padding(top = 4.dp, start = 8.dp)
                )
                Button(onClick = { onSendOtpClick() }, modifier = Modifier.padding(8.dp)) {
                    Text("Send Otp", modifier = Modifier.padding(4.dp))
                }
            }
        }
    }
}

@Composable
fun PhoneVerificationScreen(
    phoneNumber: String?,
    navController: NavController?,
    onboardingViewModel: OnboardingViewModel?
) {
    var otp by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Verify account", modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.h6)
        Text("Enter OTP sent to ${phoneNumber.toString()}", modifier = Modifier.padding(8.dp))
        TextField(value = otp, onValueChange = { newValue ->
            otp = newValue
        })
        Button(
            onClick = {
                val isOtpVerified = onboardingViewModel?.verifyOtp(otp)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Verify")
        }
    }
}


@Preview
@Composable
fun AppAndroidPreview() {
//    PhoneRegistrationScreen("", onPhoneNumberChange = {}, onSendOtpClick = {})
//    PhoneVerificationScreen("", null, null)
}