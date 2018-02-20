namespace SClab2
{
    partial class Dashboard
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.registeration = new System.Windows.Forms.Button();
            this.logout = new System.Windows.Forms.Button();
            this.login = new System.Windows.Forms.TabPage();
            this.textBoxGenre = new System.Windows.Forms.TextBox();
            this.textBoxTitle = new System.Windows.Forms.TextBox();
            this.textBoxAuthor = new System.Windows.Forms.TextBox();
            this.buttonGenre = new System.Windows.Forms.Button();
            this.buttonTitle = new System.Windows.Forms.Button();
            this.buttonAuthor = new System.Windows.Forms.Button();
            this.labelGenre = new System.Windows.Forms.Label();
            this.labelTitle = new System.Windows.Forms.Label();
            this.labelAuthor = new System.Windows.Forms.Label();
            this.listBoxSearch = new System.Windows.Forms.ListBox();
            this.AllRecords = new System.Windows.Forms.TabPage();
            this.allRecordsButton = new System.Windows.Forms.Button();
            this.allRecordsListBox = new System.Windows.Forms.ListBox();
            this.allRecordsLabel = new System.Windows.Forms.Label();
            this.books = new System.Windows.Forms.Button();
            this.journals = new System.Windows.Forms.Button();
            this.tabAllRecords = new System.Windows.Forms.TabControl();
            this.login.SuspendLayout();
            this.AllRecords.SuspendLayout();
            this.tabAllRecords.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Maiandra GD", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(247, 16);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(657, 48);
            this.label1.TabIndex = 3;
            this.label1.Text = "LIBRARY MANAGEMENT SYSTEM";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(1107, 13);
            this.button1.Margin = new System.Windows.Forms.Padding(4);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(83, 35);
            this.button1.TabIndex = 10;
            this.button1.Text = "Log In";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // registeration
            // 
            this.registeration.Location = new System.Drawing.Point(1016, 13);
            this.registeration.Margin = new System.Windows.Forms.Padding(4);
            this.registeration.Name = "registeration";
            this.registeration.Size = new System.Drawing.Size(83, 35);
            this.registeration.TabIndex = 11;
            this.registeration.Text = "Register";
            this.registeration.UseVisualStyleBackColor = true;
            this.registeration.Click += new System.EventHandler(this.registeration_Click);
            // 
            // logout
            // 
            this.logout.Location = new System.Drawing.Point(1107, 13);
            this.logout.Margin = new System.Windows.Forms.Padding(4);
            this.logout.Name = "logout";
            this.logout.Size = new System.Drawing.Size(83, 35);
            this.logout.TabIndex = 12;
            this.logout.Text = "Log Out";
            this.logout.UseVisualStyleBackColor = true;
            this.logout.Visible = false;
            this.logout.Click += new System.EventHandler(this.logout_Click);
            // 
            // login
            // 
            this.login.Controls.Add(this.listBoxSearch);
            this.login.Controls.Add(this.labelAuthor);
            this.login.Controls.Add(this.labelTitle);
            this.login.Controls.Add(this.labelGenre);
            this.login.Controls.Add(this.buttonAuthor);
            this.login.Controls.Add(this.buttonTitle);
            this.login.Controls.Add(this.buttonGenre);
            this.login.Controls.Add(this.textBoxAuthor);
            this.login.Controls.Add(this.textBoxTitle);
            this.login.Controls.Add(this.textBoxGenre);
            this.login.Location = new System.Drawing.Point(4, 28);
            this.login.Margin = new System.Windows.Forms.Padding(4);
            this.login.Name = "login";
            this.login.Padding = new System.Windows.Forms.Padding(4);
            this.login.Size = new System.Drawing.Size(1181, 358);
            this.login.TabIndex = 1;
            this.login.Text = "Search";
            this.login.UseVisualStyleBackColor = true;
            // 
            // textBoxGenre
            // 
            this.textBoxGenre.Location = new System.Drawing.Point(257, 26);
            this.textBoxGenre.Margin = new System.Windows.Forms.Padding(4);
            this.textBoxGenre.Name = "textBoxGenre";
            this.textBoxGenre.Size = new System.Drawing.Size(391, 27);
            this.textBoxGenre.TabIndex = 0;
            this.textBoxGenre.TextChanged += new System.EventHandler(this.textBoxGenre_TextChanged);
            // 
            // textBoxTitle
            // 
            this.textBoxTitle.Location = new System.Drawing.Point(257, 63);
            this.textBoxTitle.Margin = new System.Windows.Forms.Padding(4);
            this.textBoxTitle.Name = "textBoxTitle";
            this.textBoxTitle.Size = new System.Drawing.Size(391, 27);
            this.textBoxTitle.TabIndex = 1;
            this.textBoxTitle.TextChanged += new System.EventHandler(this.textBoxTitle_TextChanged);
            // 
            // textBoxAuthor
            // 
            this.textBoxAuthor.Location = new System.Drawing.Point(257, 98);
            this.textBoxAuthor.Margin = new System.Windows.Forms.Padding(4);
            this.textBoxAuthor.Name = "textBoxAuthor";
            this.textBoxAuthor.Size = new System.Drawing.Size(391, 27);
            this.textBoxAuthor.TabIndex = 2;
            // 
            // buttonGenre
            // 
            this.buttonGenre.Location = new System.Drawing.Point(673, 24);
            this.buttonGenre.Margin = new System.Windows.Forms.Padding(4);
            this.buttonGenre.Name = "buttonGenre";
            this.buttonGenre.Size = new System.Drawing.Size(100, 28);
            this.buttonGenre.TabIndex = 3;
            this.buttonGenre.Text = "Search";
            this.buttonGenre.UseVisualStyleBackColor = true;
            this.buttonGenre.Click += new System.EventHandler(this.buttonGenre_Click);
            // 
            // buttonTitle
            // 
            this.buttonTitle.Location = new System.Drawing.Point(673, 60);
            this.buttonTitle.Margin = new System.Windows.Forms.Padding(4);
            this.buttonTitle.Name = "buttonTitle";
            this.buttonTitle.Size = new System.Drawing.Size(100, 28);
            this.buttonTitle.TabIndex = 4;
            this.buttonTitle.Text = "Search";
            this.buttonTitle.UseVisualStyleBackColor = true;
            this.buttonTitle.Click += new System.EventHandler(this.buttonTitle_Click_1);
            // 
            // buttonAuthor
            // 
            this.buttonAuthor.Location = new System.Drawing.Point(673, 96);
            this.buttonAuthor.Margin = new System.Windows.Forms.Padding(4);
            this.buttonAuthor.Name = "buttonAuthor";
            this.buttonAuthor.Size = new System.Drawing.Size(100, 28);
            this.buttonAuthor.TabIndex = 5;
            this.buttonAuthor.Text = "Search";
            this.buttonAuthor.UseVisualStyleBackColor = true;
            this.buttonAuthor.Click += new System.EventHandler(this.buttonAuthor_Click);
            // 
            // labelGenre
            // 
            this.labelGenre.AutoSize = true;
            this.labelGenre.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelGenre.Location = new System.Drawing.Point(31, 34);
            this.labelGenre.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.labelGenre.Name = "labelGenre";
            this.labelGenre.Size = new System.Drawing.Size(141, 20);
            this.labelGenre.TabIndex = 6;
            this.labelGenre.Text = "Search by Genre";
            // 
            // labelTitle
            // 
            this.labelTitle.AutoSize = true;
            this.labelTitle.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitle.Location = new System.Drawing.Point(31, 70);
            this.labelTitle.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.Size = new System.Drawing.Size(129, 20);
            this.labelTitle.TabIndex = 7;
            this.labelTitle.Text = "Search by Title";
            // 
            // labelAuthor
            // 
            this.labelAuthor.AutoSize = true;
            this.labelAuthor.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelAuthor.Location = new System.Drawing.Point(31, 102);
            this.labelAuthor.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.labelAuthor.Name = "labelAuthor";
            this.labelAuthor.Size = new System.Drawing.Size(203, 20);
            this.labelAuthor.TabIndex = 8;
            this.labelAuthor.Text = "Search by Author Name";
            // 
            // listBoxSearch
            // 
            this.listBoxSearch.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.listBoxSearch.Font = new System.Drawing.Font("Maiandra GD", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBoxSearch.FormattingEnabled = true;
            this.listBoxSearch.ItemHeight = 22;
            this.listBoxSearch.Location = new System.Drawing.Point(35, 149);
            this.listBoxSearch.Margin = new System.Windows.Forms.Padding(4);
            this.listBoxSearch.Name = "listBoxSearch";
            this.listBoxSearch.Size = new System.Drawing.Size(911, 88);
            this.listBoxSearch.TabIndex = 9;
            this.listBoxSearch.SelectedIndexChanged += new System.EventHandler(this.listBoxSearch_SelectedIndexChanged);
            // 
            // AllRecords
            // 
            this.AllRecords.Controls.Add(this.journals);
            this.AllRecords.Controls.Add(this.books);
            this.AllRecords.Controls.Add(this.allRecordsLabel);
            this.AllRecords.Controls.Add(this.allRecordsListBox);
            this.AllRecords.Controls.Add(this.allRecordsButton);
            this.AllRecords.Location = new System.Drawing.Point(4, 28);
            this.AllRecords.Margin = new System.Windows.Forms.Padding(4);
            this.AllRecords.Name = "AllRecords";
            this.AllRecords.Padding = new System.Windows.Forms.Padding(4);
            this.AllRecords.Size = new System.Drawing.Size(1181, 358);
            this.AllRecords.TabIndex = 0;
            this.AllRecords.Text = "All Records";
            this.AllRecords.UseVisualStyleBackColor = true;
            // 
            // allRecordsButton
            // 
            this.allRecordsButton.Font = new System.Drawing.Font("Maiandra GD", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.allRecordsButton.Location = new System.Drawing.Point(223, 22);
            this.allRecordsButton.Margin = new System.Windows.Forms.Padding(4);
            this.allRecordsButton.Name = "allRecordsButton";
            this.allRecordsButton.Size = new System.Drawing.Size(100, 28);
            this.allRecordsButton.TabIndex = 1;
            this.allRecordsButton.Text = "All";
            this.allRecordsButton.UseVisualStyleBackColor = true;
            this.allRecordsButton.Click += new System.EventHandler(this.allRecordsButton_Click_1);
            // 
            // allRecordsListBox
            // 
            this.allRecordsListBox.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.allRecordsListBox.Font = new System.Drawing.Font("Maiandra GD", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.allRecordsListBox.FormattingEnabled = true;
            this.allRecordsListBox.ItemHeight = 22;
            this.allRecordsListBox.Location = new System.Drawing.Point(39, 75);
            this.allRecordsListBox.Margin = new System.Windows.Forms.Padding(4);
            this.allRecordsListBox.Name = "allRecordsListBox";
            this.allRecordsListBox.Size = new System.Drawing.Size(1136, 264);
            this.allRecordsListBox.TabIndex = 0;
            this.allRecordsListBox.SelectedIndexChanged += new System.EventHandler(this.allRecordsListBox_SelectedIndexChanged);
            // 
            // allRecordsLabel
            // 
            this.allRecordsLabel.AutoSize = true;
            this.allRecordsLabel.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.allRecordsLabel.Location = new System.Drawing.Point(33, 26);
            this.allRecordsLabel.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.allRecordsLabel.Name = "allRecordsLabel";
            this.allRecordsLabel.Size = new System.Drawing.Size(144, 24);
            this.allRecordsLabel.TabIndex = 2;
            this.allRecordsLabel.Text = "View Artifacts";
            this.allRecordsLabel.Click += new System.EventHandler(this.allRecordsLabel_Click);
            // 
            // books
            // 
            this.books.Font = new System.Drawing.Font("Maiandra GD", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.books.Location = new System.Drawing.Point(353, 22);
            this.books.Margin = new System.Windows.Forms.Padding(4);
            this.books.Name = "books";
            this.books.Size = new System.Drawing.Size(100, 28);
            this.books.TabIndex = 3;
            this.books.Text = "Books";
            this.books.UseVisualStyleBackColor = true;
            this.books.Click += new System.EventHandler(this.button1_Click);
            // 
            // journals
            // 
            this.journals.Font = new System.Drawing.Font("Maiandra GD", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.journals.Location = new System.Drawing.Point(477, 22);
            this.journals.Margin = new System.Windows.Forms.Padding(4);
            this.journals.Name = "journals";
            this.journals.Size = new System.Drawing.Size(100, 28);
            this.journals.TabIndex = 4;
            this.journals.Text = "Journals";
            this.journals.UseVisualStyleBackColor = true;
            this.journals.Click += new System.EventHandler(this.journals_Click);
            // 
            // tabAllRecords
            // 
            this.tabAllRecords.Controls.Add(this.AllRecords);
            this.tabAllRecords.Controls.Add(this.login);
            this.tabAllRecords.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tabAllRecords.Location = new System.Drawing.Point(16, 56);
            this.tabAllRecords.Margin = new System.Windows.Forms.Padding(4);
            this.tabAllRecords.Name = "tabAllRecords";
            this.tabAllRecords.SelectedIndex = 0;
            this.tabAllRecords.Size = new System.Drawing.Size(1189, 390);
            this.tabAllRecords.TabIndex = 2;
            // 
            // Dashboard
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1203, 446);
            this.Controls.Add(this.logout);
            this.Controls.Add(this.registeration);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tabAllRecords);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Dashboard";
            this.Text = "Library Management System";
            this.login.ResumeLayout(false);
            this.login.PerformLayout();
            this.AllRecords.ResumeLayout(false);
            this.AllRecords.PerformLayout();
            this.tabAllRecords.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        //Login Button
        public System.Windows.Forms.Button button1;
        public System.Windows.Forms.Button registeration;
        public System.Windows.Forms.Button logout;
        public System.Windows.Forms.TabPage login;
        private System.Windows.Forms.ListBox listBoxSearch;
        private System.Windows.Forms.Label labelAuthor;
        private System.Windows.Forms.Label labelTitle;
        private System.Windows.Forms.Label labelGenre;
        private System.Windows.Forms.Button buttonAuthor;
        private System.Windows.Forms.Button buttonTitle;
        private System.Windows.Forms.Button buttonGenre;
        private System.Windows.Forms.TextBox textBoxAuthor;
        private System.Windows.Forms.TextBox textBoxTitle;
        private System.Windows.Forms.TextBox textBoxGenre;
        private System.Windows.Forms.TabPage AllRecords;
        private System.Windows.Forms.Button journals;
        private System.Windows.Forms.Button books;
        private System.Windows.Forms.Label allRecordsLabel;
        private System.Windows.Forms.ListBox allRecordsListBox;
        private System.Windows.Forms.Button allRecordsButton;
        public System.Windows.Forms.TabControl tabAllRecords;
    }
}

