#!/bin/bash
set -e

# === Клонуємо лише gh-pages ===
git clone --single-branch --branch gh-pages "https://x-access-token:${GITHUB_TOKEN}@github.com/${GITHUB_REPOSITORY}.git" tmp-gh-pages
cd tmp-gh-pages

# === Збираємо всі звіти, які відповідають шаблону master|nightly|pr-report/NUMBER ===
REPORT_PATHS=$(find . -mindepth 2 -maxdepth 2 -type d | grep -E "(master|nightly|pr-report)/[0-9]+$" | sort -r)

# === Генеруємо index.html ===
cat <<EOF > index.html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Allure Reports</title>
</head>
<body>
  <h1>Allure Reports</h1>
  <ul>
EOF

for path in $REPORT_PATHS; do
  echo "    <li><a href=\"$path/index.html\">$path</a></li>" >> index.html
done

cat <<EOF >> index.html
  </ul>
</body>
</html>
EOF

# === Коммітимо, тільки якщо є зміни ===
git config user.name "github-actions[bot]"
git config user.email "github-actions[bot]@users.noreply.github.com"

if ! git diff --quiet; then
  git add index.html
  git commit -m "Update index.html [skip ci]"
  git push "https://x-access-token:${GITHUB_TOKEN}@github.com/${GITHUB_REPOSITORY}.git" gh-pages
else
  echo "No changes to commit"
fi
