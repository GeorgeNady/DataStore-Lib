package com.george.datastoreprefs.di

import com.george.datastoreprefs.repo.PrefsRepo
import com.george.datastoreprefs.service.PrefsServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val appModule = module {

    // single instance of HelloRepository
    singleOf(::PrefsServiceImpl) { bind<PrefsRepo>() }

}