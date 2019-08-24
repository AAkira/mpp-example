import UIKit
import common

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let label = UILabel(frame:
            CGRect(x: 0, y: 0, width: view.frame.size.width, height: view.frame.size.height)
        )
        label.textAlignment = .center
        label.font = label.font.withSize(26)
        self.view.addSubview(label)
        
        ApiClient().getGreeting(
            successCallback:{ response in
                label.text = response.hello
            }, errorCallback: { error in
                print(error)
            }
        )
    }
}
