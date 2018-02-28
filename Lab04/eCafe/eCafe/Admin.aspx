<%@ Page Title="About" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Admin.aspx.cs" Inherits="eCafe.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <br>
    <div >
        <h2>Users</h2>
        <asp:Table ID="userTable" class="table table-condensed" runat="server"></asp:Table>
    </div>
</asp:Content>