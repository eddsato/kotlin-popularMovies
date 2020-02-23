package com.eddsato.popularmovies.di

import com.eddsato.popularmovies.presentation.adapter.MoviesAdapter
import org.koin.dsl.module.module

val applicationModule = module(override = true) {
    factory { MoviesAdapter(get()) }
}
