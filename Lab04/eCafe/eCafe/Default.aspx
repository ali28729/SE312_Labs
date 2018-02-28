<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="eCafe._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    
    <div class="wrapper">
		<div class="header header-filter" style=" background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form" role="form" id="myForm" method="POST" action="signup-page.php">
								<div class="header header-primary text-center">
									<h4><b>Enter your info and start exploring</b></h4>
								</div>
								<div class="content">
									<div class="input-group">
                                        <label>Your Full Name</label>
										<input  type="text" id="fullname" class="form-control" name="fullname" placeholder="Full Name ..." required  runat="server">
									</div>
                                    <div class="input-group">
                                        <label>User Name</label>
										<input type="text" id="username" class="form-control" name="fullname" placeholder="User Name ..." required  runat="server">
									</div>

									<br>
									<div class="input-group">
									    <label>Gender &nbsp  </label>
										<label>
										    <input type="radio" style=" transform: scale(0.5)" class="form-control" name="optionsRadios" id="optionsRadios1" value="0" checked required  runat="server"> 
										    Male
										</label>
                                        &nbsp;
										<label>
										    <input type="radio" style=" transform: scale(0.5)" class="form-control" name="optionsRadios" id="optionsRadios2" value="1"  required  runat="server">
										Female
										</label>
									</div>		
                                    <br>
                                    <div class="input-group date" data-provide="datepicker">
										<label>Birthdate  </label>
										<input type="date" id="dob" class="form-control" name="dob" placeholder="Your birthdate ..." required runat="server"><br>
									</div>
									<div class="input-group">
										<label>Email  </label>
										<input type="email" id="email" class="form-control" name="email" placeholder="Email..." required runat="server">
                                        <br>
										<label>Password  </label>                     
										<input type="password" id="pass" name="password"  placeholder="Password..." class="form-control" required runat="server">
									</div>
								</div>
									<button class="btn btn-primary" id="btn" name="submit" runat="server" onServerClick="btnSubmit_Click" >Submit</button> 	
							</form>	
						</div>
					</div>
				</div>
			</div>
		</div>
    </div>
</asp:Content>
