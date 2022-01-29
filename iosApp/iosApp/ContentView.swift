import SwiftUI
import shared

struct ContentView: View {
    let viewModel = DependencyProvider.shared.providePictureViewModel()
        
    var body: some View {
        PicturesView(viewModel: viewModel)
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
