package com.guru.cocktails.ui.shared

sealed class DrawerItems {
    class Cocktails : DrawerItems()
    class Academy : DrawerItems()
    class Ingredients : DrawerItems()
}