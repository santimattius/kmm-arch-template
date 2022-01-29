//
//  PictureViewState.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 28/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation


enum PictureViewState {
    case loading
    case result([PictureUiModel])
    case error(String)
}
