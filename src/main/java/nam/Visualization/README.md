# Visualization

- Chương trình minh họa 3 thuật toán sắp xếp nổi bọt, chèn và lựa chọn sử dụng JavaFX 17.0.1 [(cài đặt theo hướng dẫn dưới đây)](https://openjfx.io/openjfx-docs/)
  - Đối với VSCode thì làm theo các bước sau:
    1. Tải javafx [tại đây](https://gluonhq.com/products/javafx/) và giải nén.
    2. Tạo 1 project java mới và clone repo này vào thư mục src.
    3. Chọn Java Projects -> Referenced Libraries tại góc trái bên dưới và add thêm các file trong folder `lib` giải nén được tại bước 1.
    4. Vào phần debug và tạo một file launch.json có nội dung như sau, thay đường dẫn `C:\\Program Files\\javafx-sdk-17.0.1\\lib\` của mục `vmArgs` bằng đường dẫn tới folder lib của javafx tương ứng trên máy bạn.

    ``` json
    {
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch Current File",
            "request": "launch",
            "mainClass": "${file}"
        },
        {
            "type": "java",
            "name": "Launch Main",
            "request": "launch",
            "mainClass": "Visualization.Main",
            "projectName": "visualization_c4e5a814",
            "vmArgs": "--module-path \"C:\\Program Files\\javafx-sdk-17.0.1\\lib\" --add-modules javafx.controls,javafx.fxml"
        }
    ]
    }
    ``` 
     

