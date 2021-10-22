package com.hfad.examplemvp.presentor

import com.hfad.examplemvp.model.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?

    fun bindView(view: V)
    fun getCount(): Int
}

