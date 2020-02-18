package com.eddsato.popularmovies.di

import com.eddsato.popularmovies.presentation.adapter.MoviesAdapter
import org.koin.dsl.module.module

val applicationModule = module {
    factory { MoviesAdapter(get()) }
}