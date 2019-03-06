package com.example.mymarvel.Models

data class FilmResult(
    val page: Int,
    val results: List<Films>,
    val total_pages: Int,
    val total_results: Int
)

