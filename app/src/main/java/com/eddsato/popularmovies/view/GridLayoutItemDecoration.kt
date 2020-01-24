package com.eddsato.popularmovies.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class GridLayoutItemDecoration(space: Int) : RecyclerView.ItemDecoration() {
    private var space: Int = 0

    init {
        this.space = space
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space

        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = space
        } else {
            outRect.top = 0
        }
    }
}