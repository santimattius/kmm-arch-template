//
//  PictureUiModel.swift
//  ios-arch-template
//
//  Created by Santiago Mattiauda on 21/11/21.
//

import Foundation

struct PictureUiModel: Identifiable{
    var id = UUID()
    var author: String
    var imageUrl: String
    var link: String
}

