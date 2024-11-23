package com.example.app_domain.di

import com.example.app_domain.controllers.BottomVisibilityController
import com.example.app_domain.controllers.ChangeBottomTabController
import com.example.app_domain.controllers.NavigationController
import com.example.app_domain.controllers.PointTypeController
import com.example.app_domain.controllers.SelectMarkerController
import com.example.app_domain.controllers.SelectRoomController
import com.example.app_domain.usecases.cow.FindCowByTagUseCase
import com.example.app_domain.usecases.cow.FindCowPairUseCase
import com.example.app_domain.usecases.cow.GetAllCowsUseCase
import com.example.app_domain.usecases.user.GetPinCodeUseCase
import com.example.app_domain.usecases.user.GetProfileUseCase
import com.example.app_domain.usecases.user.IsAuthUseCase
import com.example.app_domain.usecases.user.LoginUseCase
import com.example.app_domain.usecases.user.PinCodeIsSetUseCase
import com.example.app_domain.usecases.user.SetPinCodeUseCase
import org.koin.core.module.Module

fun Module.provideDomainModules() {

    single { LoginUseCase(get(), get()) }
    single { IsAuthUseCase(get()) }
    single { PinCodeIsSetUseCase(get()) }
    single { GetPinCodeUseCase(get()) }
    single { SetPinCodeUseCase(get()) }
    single { GetProfileUseCase(get()) }
    single { GetAllCowsUseCase(get()) }
    single { FindCowPairUseCase(get()) }
    single { FindCowByTagUseCase(get()) }
}

fun Module.provideControllers() {
    single { BottomVisibilityController() }
    single { ChangeBottomTabController() }
    single { PointTypeController() }
    single { SelectRoomController() }
    single { SelectMarkerController() }
    single { NavigationController() }
}