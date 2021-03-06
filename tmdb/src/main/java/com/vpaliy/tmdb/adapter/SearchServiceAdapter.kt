package com.vpaliy.tmdb.adapter

import com.vpaliy.tmdb.model.ActorModel
import com.vpaliy.tmdb.model.MovieModel
import com.vpaliy.tmdb.model.Page
import com.vpaliy.tmdb.model.TVShowModel
import com.vpaliy.tmdb.query.QueryBuilder
import com.vpaliy.tmdb.service.Search
import io.reactivex.Single

class SearchServiceAdapter(service: Search) : Search by service {
  inline fun searchMovie(query: String, options: QueryBuilder.() -> QueryBuilder)
      : Single<Page<MovieModel>>
      = searchMovies(query, options(QueryBuilder()).build())

  inline fun searchTV(query: String, options: QueryBuilder.() -> QueryBuilder)
      : Single<Page<TVShowModel>>
      = searchTV(query, options(QueryBuilder()).build())

  inline fun searchPeople(query: String, options: QueryBuilder.() -> QueryBuilder)
      : Single<Page<ActorModel>>
      = searchPeople(query, options(QueryBuilder()).build())
}