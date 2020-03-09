package com.eddsato.popularmovies.di

import com.eddsato.popularmovies.presentation.adapter.MoviesAdapter
import com.eddsato.popularmovies.presentation.viewmodel.MovieDetailViewModel
import com.eddsato.popularmovies.presentation.viewmodel.MovieViewModel
import com.eddsato.popularmovies.repository.MovieRepository
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module(override = true) {
    viewModel { MovieViewModel() }
    viewModel { MovieDetailViewModel() }

    single { MovieRepository() }
}
