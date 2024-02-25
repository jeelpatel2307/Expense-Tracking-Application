expense_tracking/
│
├── app.py
├── expenses.csv
└── README.md




import csv
import datetime
from collections import defaultdict

# Function to add expense
def add_expense(date, category, amount, description):
    with open('expenses.csv', 'a', newline='') as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow([date, category, amount, description])

# Function to view expenses
def view_expenses():
    with open('expenses.csv', 'r') as csvfile:
        reader = csv.reader(csvfile)
        for row in reader:
            print(row)

# Function to analyze expenses
def analyze_expenses():
    categories = defaultdict(float)
    total_expenses = 0
    with open('expenses.csv', 'r') as csvfile:
        reader = csv.reader(csvfile)
        for row in reader:
            categories[row[1]] += float(row[2])
            total_expenses += float(row[2])

    print("Total Expenses:", total_expenses)
    print("Average Expenses per Category:")
    for category, amount in categories.items():
        print(category, "-", amount)

# Main function
def main():
    while True:
        print("\nExpense Tracking Application")
        print("1. Add Expense")
        print("2. View Expenses")
        print("3. Analyze Expenses")
        print("4. Exit")

        choice = input("Enter your choice: ")

        if choice == '1':
            date = input("Enter date (YYYY-MM-DD): ")
            category = input("Enter category: ")
            amount = input("Enter amount: ")
            description = input("Enter description: ")
            add_expense(date, category, amount, description)
        elif choice == '2':
            view_expenses()
        elif choice == '3':
            analyze_expenses()
        elif choice == '4':
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
