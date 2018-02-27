using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.OleDb;

namespace eCafe
{
    public partial class _Default : Page
    {

        private void Page_Load(object sender, System.EventArgs e)
        {
            userTableCreation();
        }

        protected void userTableCreation()
        {
            //Use a string variable to hold the ConnectionString.
            string connectString = "Provider=Microsoft.Jet.OLEDB.4.0;"
            + "Data Source=|DataDirectory|\\cafe.mdb";

            //Create an OleDbConnection object, 
            //and then pass in the ConnectionString to the constructor.
            OleDbConnection cn = new OleDbConnection(connectString);

            //Open the connection.
            cn.Open();

            //Use a variable to hold the SQL statement.
            string selectString = "SELECT * FROM menu";

            //Create an OleDbCommand object.
            //Notice that this line passes in the SQL statement and the OleDbConnection object
            OleDbCommand cmd = new OleDbCommand(selectString, cn);

            //Send the CommandText to the connection, and then build an OleDbDataReader.
            //Note: The OleDbDataReader is forward-only.
            OleDbDataReader reader = cmd.ExecuteReader();

            //Set a table width.
            DisplayTable.Width = Unit.Percentage(90.00);
            //Create a new row for adding a table heading.
            TableRow tableHeading = new TableRow();

            //Create and add the cells that contain the Customer ID column heading text.
            TableHeaderCell IDHeading = new TableHeaderCell();
            IDHeading.Text = "ID";
            IDHeading.HorizontalAlign = HorizontalAlign.Left;
            tableHeading.Cells.Add(IDHeading);

            //Create and add the cells that contain the Contact Name column heading text.
            TableHeaderCell NameHeading = new TableHeaderCell();
            NameHeading.Text = "Name";
            NameHeading.HorizontalAlign = HorizontalAlign.Left;
            tableHeading.Cells.Add(NameHeading);

            //Create and add the cells that contain the Phone column heading text.
            TableHeaderCell TypeHeading = new TableHeaderCell();
            TypeHeading.Text = "Type";
            TypeHeading.HorizontalAlign = HorizontalAlign.Left;
            tableHeading.Cells.Add(TypeHeading);

            //Create and add the cells that contain the Phone column heading text.
            TableHeaderCell PriceHeading = new TableHeaderCell();
            PriceHeading.Text = "Price";
            PriceHeading.HorizontalAlign = HorizontalAlign.Left;
            tableHeading.Cells.Add(PriceHeading);

            //Create and add the cells that contain the Phone column heading text.
            TableHeaderCell QuantityHeading = new TableHeaderCell();
            QuantityHeading.Text = "Quantity";
            QuantityHeading.HorizontalAlign = HorizontalAlign.Left;
            tableHeading.Cells.Add(QuantityHeading);

            DisplayTable.Rows.Add(tableHeading);

            //Loop through the resultant data selection and add the data value
            //for each respective column in the table.
            while (reader.Read())
            {
                TableRow detailsRow = new TableRow();
                TableCell IDCell = new TableCell();
                IDCell.Text = reader["ID"].ToString();
                detailsRow.Cells.Add(IDCell);

                TableCell NameCell = new TableCell();
                NameCell.Text = reader["Nam"].ToString();
                detailsRow.Cells.Add(NameCell);

                TableCell TypeCell = new TableCell();
                TypeCell.Text = reader["type"].ToString();
                detailsRow.Cells.Add(TypeCell);

                TableCell PriceCell = new TableCell();
                PriceCell.Text = reader["price"].ToString();
                detailsRow.Cells.Add(PriceCell);

                TableCell QuantityCell = new TableCell();
                QuantityCell.Text = reader["quantity"].ToString();
                detailsRow.Cells.Add(QuantityCell);

                TableCell tabButton = new TableCell();
                Button button = new Button();
                button.Click += new EventHandler(deluser_button_Click);
                button.Text = "Delete";
                button.ID = reader["ID"].ToString();
                //Button.CssClass = "btn btn-default";
                tabButton.Controls.Add(button);
                detailsRow.Cells.Add(tabButton);
                //DisplayTable.Rows[0].Cells[0].Controls.Add(button);

                DisplayTable.Rows.Add(detailsRow);
            }

            //Close the reader and the related connection.
            reader.Close();
            cn.Close();
        }

        protected void deluser_button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            int buttonID = Convert.ToInt32(button.ID);
            string connectString = "Provider=Microsoft.Jet.OLEDB.4.0;" + "Data Source=|DataDirectory|\\cafe.mdb";
            OleDbConnection cn = new OleDbConnection(connectString);
            cn.Open();
            string selectString = "  DELETE FROM menu WHERE ID = " + buttonID + " ";
            OleDbCommand cmd = new OleDbCommand(selectString, cn);   
            int reader = (int)cmd.ExecuteNonQuery();
            if (reader >= 0) { }
            else
            {
                Console.WriteLine("Error deleting data from Database!");
            }
            cn.Close();
        }
    }
}