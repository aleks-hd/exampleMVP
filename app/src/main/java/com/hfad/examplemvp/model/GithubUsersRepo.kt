package com.hfad.examplemvp.model

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("Rey"),
        GithubUser ("Day"),
        GithubUser ("Mark"),
        GithubUser ("Jordg"),
        GithubUser ("Killy")
    )
    fun getUsers():List<GithubUser>{
        return repositories
    }
}