import os

def search_files(root_dir, target_string):
    for dirpath, _, filenames in os.walk(root_dir):
        for file in filenames:
            filepath = os.path.join(dirpath, file)
            try:
                with open(filepath, 'r', encoding='utf-8', errors='ignore') as f:
                    lines = f.readlines()
                    for i, line in enumerate(lines):
                        if target_string in line:
                            print(f"\n📄 Found in: {filepath}")
                            if i > 0:
                                print(f"  Before: {lines[i - 1].strip()}")
                            print(f"  Match : {line.strip()}")
                            if i < len(lines) - 1:
                                print(f"  After : {lines[i + 1].strip()}")
            except Exception as e:
                print(f"⚠️ Could not read {filepath}: {e}")

# Example usage
if __name__ == "__main__":
    search_root = "."  # Replace with your path
    search_term = "MetadataMap()"  # Replace with the string you're looking for
    search_files(search_root, search_term)
