package com.example.app_domain.controllers

import com.example.app_domain.controllers.datacontrol.PublishDataController
import online.jutter.roadmapview.data.models.map.RMRoom


class SelectRoomController {
    val state = PublishDataController<RMRoom>()

    fun select(room: RMRoom) = state.emit(room)
}