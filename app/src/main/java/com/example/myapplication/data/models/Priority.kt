package com.example.myapplication.data.models

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.theme.HighPriorityColor
import com.example.myapplication.ui.theme.LowPriorityColor
import com.example.myapplication.ui.theme.MediumPriorityColor
import com.example.myapplication.ui.theme.NonePriorityColor


enum class Priority(val color : Color){
    High(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}