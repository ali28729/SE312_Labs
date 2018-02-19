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
            this.allRecordsListBox = new System.Windows.Forms.ListBox();
            this.allRecordsButton = new System.Windows.Forms.Button();
            this.tabAllRecords = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.allRecordsLabel = new System.Windows.Forms.Label();
            this.tabSearch = new System.Windows.Forms.TabPage();
            this.listBoxSearch = new System.Windows.Forms.ListBox();
            this.labelAuthor = new System.Windows.Forms.Label();
            this.labelTitle = new System.Windows.Forms.Label();
            this.labelGenre = new System.Windows.Forms.Label();
            this.buttonAuthor = new System.Windows.Forms.Button();
            this.buttonTitle = new System.Windows.Forms.Button();
            this.buttonGenre = new System.Windows.Forms.Button();
            this.textBoxAuthor = new System.Windows.Forms.TextBox();
            this.textBoxTitle = new System.Windows.Forms.TextBox();
            this.textBoxGenre = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.tabAllRecords.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabSearch.SuspendLayout();
            this.SuspendLayout();
            // 
            // allRecordsListBox
            // 
            this.allRecordsListBox.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.allRecordsListBox.Font = new System.Drawing.Font("Maiandra GD", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.allRecordsListBox.FormattingEnabled = true;
            this.allRecordsListBox.ItemHeight = 18;
            this.allRecordsListBox.Location = new System.Drawing.Point(29, 61);
            this.allRecordsListBox.Name = "allRecordsListBox";
            this.allRecordsListBox.Size = new System.Drawing.Size(852, 216);
            this.allRecordsListBox.TabIndex = 0;
            // 
            // allRecordsButton
            // 
            this.allRecordsButton.Font = new System.Drawing.Font("Maiandra GD", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.allRecordsButton.Location = new System.Drawing.Point(198, 20);
            this.allRecordsButton.Name = "allRecordsButton";
            this.allRecordsButton.Size = new System.Drawing.Size(75, 23);
            this.allRecordsButton.TabIndex = 1;
            this.allRecordsButton.Text = "Search";
            this.allRecordsButton.UseVisualStyleBackColor = true;
            this.allRecordsButton.Click += new System.EventHandler(this.allRecordsButton_Click_1);
            // 
            // tabAllRecords
            // 
            this.tabAllRecords.Controls.Add(this.tabPage1);
            this.tabAllRecords.Controls.Add(this.tabSearch);
            this.tabAllRecords.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tabAllRecords.Location = new System.Drawing.Point(12, 55);
            this.tabAllRecords.Name = "tabAllRecords";
            this.tabAllRecords.SelectedIndex = 0;
            this.tabAllRecords.Size = new System.Drawing.Size(892, 307);
            this.tabAllRecords.TabIndex = 2;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.allRecordsLabel);
            this.tabPage1.Controls.Add(this.allRecordsListBox);
            this.tabPage1.Controls.Add(this.allRecordsButton);
            this.tabPage1.Location = new System.Drawing.Point(4, 25);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(884, 278);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "All Records";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // allRecordsLabel
            // 
            this.allRecordsLabel.AutoSize = true;
            this.allRecordsLabel.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.allRecordsLabel.Location = new System.Drawing.Point(25, 21);
            this.allRecordsLabel.Name = "allRecordsLabel";
            this.allRecordsLabel.Size = new System.Drawing.Size(142, 19);
            this.allRecordsLabel.TabIndex = 2;
            this.allRecordsLabel.Text = "Veiw all artifacts";
            // 
            // tabSearch
            // 
            this.tabSearch.Controls.Add(this.listBoxSearch);
            this.tabSearch.Controls.Add(this.labelAuthor);
            this.tabSearch.Controls.Add(this.labelTitle);
            this.tabSearch.Controls.Add(this.labelGenre);
            this.tabSearch.Controls.Add(this.buttonAuthor);
            this.tabSearch.Controls.Add(this.buttonTitle);
            this.tabSearch.Controls.Add(this.buttonGenre);
            this.tabSearch.Controls.Add(this.textBoxAuthor);
            this.tabSearch.Controls.Add(this.textBoxTitle);
            this.tabSearch.Controls.Add(this.textBoxGenre);
            this.tabSearch.Location = new System.Drawing.Point(4, 25);
            this.tabSearch.Name = "tabSearch";
            this.tabSearch.Padding = new System.Windows.Forms.Padding(3);
            this.tabSearch.Size = new System.Drawing.Size(884, 278);
            this.tabSearch.TabIndex = 1;
            this.tabSearch.Text = "Search";
            this.tabSearch.UseVisualStyleBackColor = true;
            // 
            // listBoxSearch
            // 
            this.listBoxSearch.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.listBoxSearch.Font = new System.Drawing.Font("Maiandra GD", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBoxSearch.FormattingEnabled = true;
            this.listBoxSearch.ItemHeight = 18;
            this.listBoxSearch.Location = new System.Drawing.Point(26, 121);
            this.listBoxSearch.Name = "listBoxSearch";
            this.listBoxSearch.Size = new System.Drawing.Size(683, 72);
            this.listBoxSearch.TabIndex = 9;
            // 
            // labelAuthor
            // 
            this.labelAuthor.AutoSize = true;
            this.labelAuthor.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelAuthor.Location = new System.Drawing.Point(23, 83);
            this.labelAuthor.Name = "labelAuthor";
            this.labelAuthor.Size = new System.Drawing.Size(164, 16);
            this.labelAuthor.TabIndex = 8;
            this.labelAuthor.Text = "Search by Author Name";
            // 
            // labelTitle
            // 
            this.labelTitle.AutoSize = true;
            this.labelTitle.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitle.Location = new System.Drawing.Point(23, 57);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.Size = new System.Drawing.Size(105, 16);
            this.labelTitle.TabIndex = 7;
            this.labelTitle.Text = "Search by Title";
            // 
            // labelGenre
            // 
            this.labelGenre.AutoSize = true;
            this.labelGenre.Font = new System.Drawing.Font("Maiandra GD", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelGenre.Location = new System.Drawing.Point(23, 28);
            this.labelGenre.Name = "labelGenre";
            this.labelGenre.Size = new System.Drawing.Size(115, 16);
            this.labelGenre.TabIndex = 6;
            this.labelGenre.Text = "Search by Genre";
            // 
            // buttonAuthor
            // 
            this.buttonAuthor.Location = new System.Drawing.Point(313, 80);
            this.buttonAuthor.Name = "buttonAuthor";
            this.buttonAuthor.Size = new System.Drawing.Size(75, 23);
            this.buttonAuthor.TabIndex = 5;
            this.buttonAuthor.Text = "Search";
            this.buttonAuthor.UseVisualStyleBackColor = true;
            this.buttonAuthor.Click += new System.EventHandler(this.buttonAuthor_Click);
            // 
            // buttonTitle
            // 
            this.buttonTitle.Location = new System.Drawing.Point(313, 50);
            this.buttonTitle.Name = "buttonTitle";
            this.buttonTitle.Size = new System.Drawing.Size(75, 23);
            this.buttonTitle.TabIndex = 4;
            this.buttonTitle.Text = "Search";
            this.buttonTitle.UseVisualStyleBackColor = true;
            this.buttonTitle.Click += new System.EventHandler(this.buttonTitle_Click_1);
            // 
            // buttonGenre
            // 
            this.buttonGenre.Location = new System.Drawing.Point(313, 21);
            this.buttonGenre.Name = "buttonGenre";
            this.buttonGenre.Size = new System.Drawing.Size(75, 23);
            this.buttonGenre.TabIndex = 3;
            this.buttonGenre.Text = "Search";
            this.buttonGenre.UseVisualStyleBackColor = true;
            this.buttonGenre.Click += new System.EventHandler(this.buttonGenre_Click);
            // 
            // textBoxAuthor
            // 
            this.textBoxAuthor.Location = new System.Drawing.Point(193, 80);
            this.textBoxAuthor.Name = "textBoxAuthor";
            this.textBoxAuthor.Size = new System.Drawing.Size(100, 23);
            this.textBoxAuthor.TabIndex = 2;
            // 
            // textBoxTitle
            // 
            this.textBoxTitle.Location = new System.Drawing.Point(193, 51);
            this.textBoxTitle.Name = "textBoxTitle";
            this.textBoxTitle.Size = new System.Drawing.Size(100, 23);
            this.textBoxTitle.TabIndex = 1;
            // 
            // textBoxGenre
            // 
            this.textBoxGenre.Location = new System.Drawing.Point(193, 21);
            this.textBoxGenre.Name = "textBoxGenre";
            this.textBoxGenre.Size = new System.Drawing.Size(100, 23);
            this.textBoxGenre.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Maiandra GD", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(185, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(523, 39);
            this.label1.TabIndex = 3;
            this.label1.Text = "LIBRARY MANAGEMENT SYSTEM";
            // 
            // Dashboard
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(902, 362);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tabAllRecords);
            this.Name = "Dashboard";
            this.Text = "Library Management System";
            this.tabAllRecords.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabSearch.ResumeLayout(false);
            this.tabSearch.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox allRecordsListBox;
        private System.Windows.Forms.Button allRecordsButton;
        private System.Windows.Forms.TabControl tabAllRecords;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabSearch;
        private System.Windows.Forms.Label allRecordsLabel;
        private System.Windows.Forms.Label labelAuthor;
        private System.Windows.Forms.Label labelTitle;
        private System.Windows.Forms.Label labelGenre;
        private System.Windows.Forms.Button buttonAuthor;
        private System.Windows.Forms.Button buttonTitle;
        private System.Windows.Forms.Button buttonGenre;
        private System.Windows.Forms.TextBox textBoxAuthor;
        private System.Windows.Forms.TextBox textBoxTitle;
        private System.Windows.Forms.TextBox textBoxGenre;
        private System.Windows.Forms.ListBox listBoxSearch;
        private System.Windows.Forms.Label label1;
    }
}

