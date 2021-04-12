<div class="col-12">
  <div class="mt-5 row">
    <div class="col-6">
      <button class="btn btn-success">Thêm mới</button>
    </div>
    <div class="col-4"></div>
    <div class="col-2 d-flex justify-content-end">
      <select class="form-select">
        <option value="10" selected>10</option>
        <option value="20">20</option>
        <option value="50">50</option>
        <option value="100">100</option>
      </select>
    </div>
  </div>
  <div class="mt-5 table-responsive">
    <table class="table table-striped">
      <thead>
        <tr>
          <td>Id</td>
          <td>Name</td>
          <td>Email</td>
          <td>Gender</td>
          <td>Role</td>
          <td>No. Post</td>
          <td colspan="2">Action</td>
        </tr>
      </thead>
      <tbody>
     		<c:forEach var="user" items="${ listUser }">
        <tr>
          <td>${ user.id }</td>
          <td>${ user.name }</td>
          <td>${ user.email }</td>
          <td>${ user.gender }</td>
          <td>${ user.role }</td>
          <td>${ user.posts.size() }</td>
          <td>
            <a
            	href="/PT15307UD/admin/user/edit?id=${ user.id }"
            	class="btn btn-primary">Update</a>
          </td>
          <td>
            <form action="/PT15307UD/users/delete?id=${ user.id }" method="POST">
	            <button class="btn btn-danger">Delete</button>
            </form>
          </td>
        </tr>
     		</c:forEach>
      </tbody>
    </table>
    
    <ul class="pagination">
    	<li class="page-item">
    		<a class="page-link" href="/PT15307UD/users?page=${ page - 1 }"> << </a>
    	</li>
    	<li class="page-item">
    		<a class="page-link" href="/PT15307UD/users?page=${ page + 1 }"> >> </a>
    	</li>
    </ul>
  </div>
</div>