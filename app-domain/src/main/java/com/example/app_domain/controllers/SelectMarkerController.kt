package com.example.app_domain.controllers

import com.example.app_domain.controllers.datacontrol.PublishDataController
import online.jutter.roadmapview.data.models.map.RMMarker


class SelectMarkerController {
    val state = PublishDataController<RMMarker>()

    fun select(notifications: RMMarker) = state.emit(notifications)
}