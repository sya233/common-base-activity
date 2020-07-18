package com.upai.commonbaseactivity.main

class MainPresenter(var mainView: MainView, var mainModel: MainModel) {

    fun btnMainClick() {
        mainView.showToast("Successful")
    }

}