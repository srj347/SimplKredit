package org.example.simplkredit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.simplkredit.constants.Route
import org.example.simplkredit.constants.RouteArguments
import org.example.simplkredit.ui.PhoneRegistrationScreen
import org.example.simplkredit.ui.PhoneVerificationScreen
import org.example.simplkredit.viewmodels.OnboardingViewModel

class MainActivity : ComponentActivity() {
    val onboardingViewModel: OnboardingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            App()
            AppNavigation(onboardingViewModel)
        }
    }
}

@Composable
fun AppNavigation(onboardingViewModel: OnboardingViewModel) {
    val loginNavController = rememberNavController()

    NavHost(navController = loginNavController, startDestination = Route.PHONE_REGISTRATION){
        composable(Route.PHONE_REGISTRATION) {
            PhoneRegistrationScreen(loginNavController, onboardingViewModel)
        }
        composable("${Route.PHONE_VERIFICATION}/{${RouteArguments.phoneNumber}}") {
            val phoneNumber = it.arguments?.getString(RouteArguments.phoneNumber)
            PhoneVerificationScreen(phoneNumber, loginNavController, onboardingViewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
}