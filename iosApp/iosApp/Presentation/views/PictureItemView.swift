//
//  PictureItemView.swift
//  ios-arch-template
//
//  Created by Santiago Mattiauda on 24/11/21.
//

import SwiftUI

struct PictureItemView: View {
    
    var picture: PictureUiModel
    
    var body: some View {
        VStack(alignment:.center) {
            AsyncImage(url: URL(string: picture.imageUrl)) { image in
                image
                    .resizable()
                    .aspectRatio(contentMode:.fit)
                    .overlay{
                        Rectangle()
                            .scaledToFill()
                            .foregroundColor(.gray)
                            .opacity(0.5)
                            .overlay(
                                VStack(alignment:.center) {
                                    Text(picture.author)
                                        .fontWeight(.bold)
                                        .font(.title)
                                        .foregroundColor(.white)
                                        .lineSpacing(8)
                                        .padding()
                                }
                            )
                    }
            } placeholder: {
                ProgressView()
            }
            
           
        }
        .frame(minWidth: 300)
        .cornerRadius(4)
    }
}

struct PictureItemView_Previews: PreviewProvider {
    static var previews: some View {
        PictureItemView(
            picture: PictureUiModel(
                author: "Prueba", imageUrl: "https://images.pexels.com/photos/2422915/pexels-photo-2422915.jpeg?auto=compress&cs=tinysrgb&h=350", link: "")
        )
    }
}
