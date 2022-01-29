//
//  PicturesView.swift
//  ios-arch-template
//
//  Created by Santiago Mattiauda on 21/11/21.
//

import SwiftUI

struct PicturesView: View {
    
    @ObservedObject var viewModel: PictureViewModel
    @State private var selectedPicture: PictureUiModel?
    
    var body: some View {
        NavigationView{
            content()
            .onAppear{
                viewModel.loadPictures()
            }
            .navigationTitle("KMM Arch Template")
            .sheet(item: self.$selectedPicture) { picture in
                SafariView(url:URL(string: picture.link)!)
            }
        }
    }
    
    private func content() -> AnyView {
            switch viewModel.state {
            case .loading:
                return AnyView(ProgressView())
            case .result(let pictures):
                return AnyView(
                    List(pictures){ picture in
                        PictureItemView(
                            picture:picture
                        )
                        .listRowSeparator(.hidden)
                        .onTapGesture {
                            self.selectedPicture = picture
                        }
                    }
                    .listStyle(PlainListStyle())
                )
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
}
