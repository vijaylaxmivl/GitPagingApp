
package com.vl.gitpagingapp.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitResponse {

    @SerializedName("id")
    @Expose
    public Integer id;
    public String name;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("open_issues_count")
    @Expose
    public Integer openIssuesCount;
    @SerializedName("license")
    @Expose
    public License license=new License();
    @SerializedName("open_issues")
    @Expose
    public Integer openIssues;
    @SerializedName("permissions")
    @Expose
    public Permissions permissions;

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
