I.GIỚI THIỆU

	1.Mục đích
		-Khi ứng viên ứng tuyển, chỉ cần nhập thông tin các nhân và các các kĩ năng cá nhân, bạn có thể xem được cá danh sách các công việc phù hợp
		-Khi công ty cần tuyển dụng, chỉ cần nhập thông tin công ty và các thông tin ứng tuyển, sẽ hiện thông tin các ứng viên phù hợp
	2.Công nghệ sử dụng
		-Backend:
			Framework: Spring Boot.
			Cơ sở dữ liệu: MariaDB.
			ORM: Spring Data JPA.

		-Frontend:
			Template engine: Thymeleaf.
			Thư viện giao diện: Bootstrap.
			Thư viện hỗ trợ com.neovisionaries: Xử lý mã quốc gia.

	3.Các chức năng chính

	-Đối với ứng viên:
			Hiển thị danh sách các công việc khi log vào.
			Tìm kiếm các công việc phù hợp với bản thân.
			Tìm kiếm công việc theo tên công việc hoặc tên công ty.
			Cho biết skill còn thiếu của bản thân bằng cách nhập tên công việc và tên công ty.
			Thêm, xóa, sửa các kỹ năng, thông tin cá nhân của bản thân.

	-Đối với công ty:
			Hiển thị danh sách tất cả ứng viên khi log vào.
			Tìm kiếm, xem thông tin chi tiết các ứng viên phù hợp với công việc của chính công ty.
			Cho phép đăng tin tuyển dụng với skill mong muốn, cũng như chỉnh sửa, gỡ bảng tin.
			Cho phép chỉnh sửa thông tin của chính công ty.

II. HƯỚNG DẪN SỬ DỤNG

	-Cấu hình file application.properties để dùng database.
	-Tạo trống database tên works.
	-Start dự án và truy cập http://localhost:8080/.

II. ĐÁNH GIÁ

	-Ưu điểm:
		Cơ bản hoàn thành Lab week 05.
	-Hạn chế:
		Giao diện sử dung boostrap có phần đơn giản.
		Chưa dùng session cho các phiên đăng nhập.
		Chưa tích hợp AI.
		Chư tích hợp thông báo để gửi mail.

